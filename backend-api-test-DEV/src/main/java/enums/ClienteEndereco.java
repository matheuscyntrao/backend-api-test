package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Enderecos;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import utils.CPF;
import utils.service.Cache;

@Getter
@AllArgsConstructor
public enum ClienteEndereco {
    ENDERECO_SIMPLES {
        @Override
        public PostClienteRequest_v2_Enderecos pojo() {
            return PostClienteRequest_v2_Enderecos.builder()
                    .codEntidadeComercial(null)
                    .bairro(Cache.faker.address().cityName())
                    .cep(90680050)
                    .cidade("Porto Alegre")
                    .codCidade(7718L)
                    .codLogradouro(119192L)
                    .complemento("teste QA")
                    .identificador(null)
                    .logradouro(Cache.faker.address().streetName())
                    .numero(Integer.parseInt(Cache.faker.address().streetAddressNumber()))
                    .preferencial("S")
                    .referencia(null)
                    .seqEndEntidadeComercial(null)
                    .seqEndEntidadeComercial(null)
                    .uf(Cache.faker.address().stateAbbr())
                    .build();
        }
    };

    public abstract PostClienteRequest_v2_Enderecos pojo();
}
