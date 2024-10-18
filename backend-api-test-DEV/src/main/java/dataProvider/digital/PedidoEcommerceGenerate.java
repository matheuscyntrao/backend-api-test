package dataProvider.digital;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.digital.pedidosEcommerce.request.PostPedidoRequest_v1;
import utils.CucumberUtils;

@Getter
@AllArgsConstructor
public enum PedidoEcommerceGenerate {
    CARTAO_MASTER {
        @Override
        public PostPedidoRequest_v1 pojo() throws JsonProcessingException {
            return PedidoEcommerceGenerateStatico.example();
        }
    },
    CARTAO_BANRISUL {
        @Override
        public PostPedidoRequest_v1 pojo() {
            return PostPedidoRequest_v1.builder().build();
        }
    };

    public abstract PostPedidoRequest_v1 pojo() throws JsonProcessingException;
}


class PedidoEcommerceGenerateStatico {
    public static PostPedidoRequest_v1 example() throws JsonProcessingException {
        String body = "{\n" +
                "    \"codigoSituacaoPedido\": 2,\n" +
                "    \"codigoFilial\": 507,\n" +
                "    \"numeroCarrinho\": 4416231,\n" +
                "    \"podePontuar\": true,\n" +
                "    \"tipoPedido\": \"I\",\n" +
                "    \"origemPedido\": 5,\n" +
                "    \"pedidoUrgente\": \"N\",\n" +
                "    \"valorTotalPedido\": 60.00,\n" +
                "    \"cliente\": {\n" +
                "        \"codigoCliente\": 6962417,\n" +
                "        \"ddd\": 41,\n" +
                "        \"telefone\": \"996008178\",\n" +
                "        \"cpf\": \"83922431968\"\n" +
                "    },\n" +
                "    \"enderecoEntrega\": {\n" +
                "        \"codigoLocalidade\": 5757,\n" +
                "        \"codigoLogradouro\": 378629,\n" +
                "        \"numeroEndereco\": 244,\n" +
                "        \"complementoEndereco\": \"casa\",\n" +
                "        \"referenciaEntrega\": \"\"\n" +
                "    },\n" +
                "    \"entrega\": {\n" +
                "        \"codigoFormaEntrega\": 3,\n" +
                "        \"codigoTipoEntrega\": 1,\n" +
                "        \"codigoTaxa\": 958340,\n" +
                "        \"valorTaxa\": 0,\n" +
                "        \"dataHoraEntrega\": \"04/04/2020 18:00\",\n" +
                "        \"dataHoraSaidaRota\": \"04/04/2020 13:00\"\n" +
                "    },\n" +
                "    \"conveniosUtilizados\": [],\n" +
                "    \"itens\": [\n" +
                "        {\n" +
                "            \"codigoItem\": 845140,\n" +
                "            \"nome\": \"Quadrados De Algodão Bellacotton Maxi Bebê C/50\",\n" +
                "            \"ean\": \"7898924640951\",\n" +
                "            \"quantidade\": 1,\n" +
                "            \"valorUnitario\": 60.00,\n" +
                "            \"valorTotal\": 60.00,\n" +
                "            \"percentualIsencao\": 0,\n" +
                "            \"numeroItem\": 1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"formaPagamentoCartoes\": [\n" +
                "        {\n" +
                "            \"codigoFormaPagamento\": 34,\n" +
                "            \"tipoPagamento\": \"P\",\n" +
                "            \"valor\": 60.00,\n" +
                "            \"codigoFilialConvenio\": 1002,\n" +
                "            \"codigoConvenio\": 254487,\n" +
                "            \"confCodigoCondicaoPagamento\": 2,\n" +
                "            \"confSequenciaCondicao\": 3,\n" +
                "            \"idCartao\": 309893,\n" +
                "            \"authorizerId\": 2,\n" +
                "            \"installmentType\": 4,\n" +
                "            \"installments\": 1\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return CucumberUtils.getObjectBodyFromJson(body, PostPedidoRequest_v1.class);
    }
}