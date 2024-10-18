package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Contatos;
import model.crossover.cliente.request.PostClienteRequest_v2_Enderecos;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import utils.CPF;
import utils.service.Cache;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public enum Cliente {
    CLIENTE_SIMPLES {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPF())
                    .nome(Cache.faker.name().fullName())
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    },
    CLIENTE_COMPLETO {
        @Override
        public PostClienteRequest_v2 pojo() {
            List<PostClienteRequest_v2_Enderecos> enderecos = new ArrayList<>();
            enderecos.add(ClienteEndereco.ENDERECO_SIMPLES.pojo());
            List<PostClienteRequest_v2_Contatos> contatos = new ArrayList<>();
            contatos.add(ClienteContato.CONTATO_CELULAR.pojo());
            contatos.add(ClienteContato.CONTATO_EMAIL.pojo());

            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPF())
                    .nome(Cache.faker.name().fullName())
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .enderecos(enderecos)
                    .contatos(contatos)
                    .build();
        }
    };

    public abstract PostClienteRequest_v2 pojo();
}
