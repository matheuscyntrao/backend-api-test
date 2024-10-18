package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Contatos;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import utils.CPF;
import utils.PatternRegex;
import utils.service.Cache;

@Getter
@AllArgsConstructor
public enum ClienteContato {

    CONTATO_EMAIL {
        @Override
        public PostClienteRequest_v2_Contatos pojo() {
            return PostClienteRequest_v2_Contatos.builder()
                    .ddd(0)
                    .ddi(55)
                    .email(Cache.faker.bothify(PatternRegex.FAKER_EMAIL))
                    .observacao("Loja Virtual")
                    .codTipoComunicacao(4L)
                    .descTipoComunicacao("E-MAIL")
                    .build();
        }
    },
    CONTATO_CELULAR {
        @Override
        public PostClienteRequest_v2_Contatos pojo() {
            return PostClienteRequest_v2_Contatos.builder()
                    .ddd(51)
                    .ddi(55)
                    .codTipoComunicacao(47L)
                    .descTipoComunicacao("CELULAR")
                    .numero(Cache.faker.bothify("99#######"))
                    .build();
        }
    };

    public abstract PostClienteRequest_v2_Contatos pojo();
}
