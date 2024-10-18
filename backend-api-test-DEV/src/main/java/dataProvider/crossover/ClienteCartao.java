package dataProvider.crossover;


import helpers.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClientesIdclienteCartoesRequest_v2;
import utils.service.Cache;

@Getter
@AllArgsConstructor
public enum ClienteCartao {
    CARTAO_MASTER {
        @Override
        public PostClientesIdclienteCartoesRequest_v2 pojo(Long codCliente, String titular) {
            return PostClientesIdclienteCartoesRequest_v2.builder()
                    .codCliente(codCliente)
                    .idCartao(null)
                    .idAutorizadora(null)
                    .numeroCartao(Cartao.gerarSufixo("52", 16, "0"))
                    .cvvCartao(Cache.faker.bothify("###"))
                    .dataExpiracaoCartao("0524")
                    .titular(titular)
                    .cartaoPrincipal("S")
                    .build();
        }
    },
    CARTAO_BANRISUL {
        @Override
        public PostClientesIdclienteCartoesRequest_v2 pojo(Long codCliente, String titular) {
            return PostClientesIdclienteCartoesRequest_v2.builder().build();
        }
    };

    public abstract PostClientesIdclienteCartoesRequest_v2 pojo(Long codCliente, String titular);
}
