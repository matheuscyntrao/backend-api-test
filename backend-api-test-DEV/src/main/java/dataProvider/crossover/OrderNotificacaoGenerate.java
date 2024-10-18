package dataProvider.crossover;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.notificacao.PostOrderRequest_v1;
import utils.CucumberUtils;

@Getter
@AllArgsConstructor
public enum OrderNotificacaoGenerate {
    ORDER_SIMPLES {
        @Override
        public PostOrderRequest_v1 pojo(String tipoPedido, String situacaoPedido, String formaEntrega, Long pedido) throws JsonProcessingException {
            PostOrderRequest_v1 body = OrderNotificacaoGenerateDados.example();
            body.getDelivery().setDeliveryMethod(formaEntrega);
            body.setStatus(situacaoPedido);
            body.setOrderType(tipoPedido);
            body.setOrderId(pedido);
            return body;
        }
    }
    ,PEDIDO_EM_ANALISE_MANUAL {
        @Override
        public PostOrderRequest_v1 pojo(String tipoPedido, String situacaoPedido, String formaEntrega, Long pedido) throws JsonProcessingException {
            PostOrderRequest_v1 body = OrderNotificacaoGenerateDados.analiseManual();
            return body;
        }
    };

    public abstract PostOrderRequest_v1 pojo(String tipoPedido, String situacaoPedido, String formaEntrega, Long pedido) throws JsonProcessingException;
}


class OrderNotificacaoGenerateDados {
    public static PostOrderRequest_v1 example() throws JsonProcessingException {
        String body = "{\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"code\": 502320,\n" +
                "            \"number\": 1,\n" +
                "            \"deliveryId\": \"1\",\n" +
                "            \"amount\": 2,\n" +
                "            \"deliveryAmount\": 2,\n" +
                "            \"unitaryValue\": 69.99,\n" +
                "            \"totalValue\": 139.98,\n" +
                "            \"exemptionPercentage\": 6,\n" +
                "            \"promotion\": {\n" +
                "                \"code\": 108159,\n" +
                "                \"subsidiaryCode\": 1002\n" +
                "            },\n" +
                "            \"pbmAuthorizations\": []\n" +
                "        },\n" +
                "        {\n" +
                "            \"code\": 806190,\n" +
                "            \"number\": 2,\n" +
                "            \"deliveryId\": \"1\",\n" +
                "            \"amount\": 1,\n" +
                "            \"unitaryValue\": 40.33,\n" +
                "            \"totalValue\": 40.33,\n" +
                "            \"pbmAuthorizations\": []\n" +
                "        }\n" +
                "    ],\n" +
                "    \"delivery\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"subsidiary\": 507,\n" +
                "        \"deliveryMethod\": \"MOTOBOY\",\n" +
                "        \"deliveryType\": \"RETIRADA_BALCAO\",\n" +
                "        \"deliveryDate\": \"2021-01-29T00:01\",\n" +
                "        \"feeCode\": 806190,\n" +
                "        \"feeValue\": 40.33,\n" +
                "        \"address\": {\n" +
                "\"localityCode\": 7448,\n" +
                "            \"streetCode\": 334761,\n" +
                "            \"number\": 354,\n" +
                "            \"complement\": \"BCO BRASIL\",\n" +
                "            \"deliveryReference\": \"PESSOA JURIDICA\",\n" +
                "            \"uf\": \"RS\",\n" +
                "            \"city\": \"FLORES DA CUNHA\",\n" +
                "            \"district\": \"CENTRO\",\n" +
                "            \"street\": \"DOUTOR MONTAURI\",\n" +
                "            \"zipCode\": 95270000,\n" +
                "            \"ibgeCityCode\": \"438201\",\n" +
                "            \"provinceName\": \"RIO GRANDE DO SUL\",\n" +
                "            \"countryCode\": \"1058\",\n" +
                "            \"countryAcronym\": \"BR\",\n" +
                "            \"countryName\": \"BRASIL\",\n" +
                "            \"streetType\": \"R\"" +
                "        },\n" +
                "        \"chargeFee\": false\n" +
                "    },\n" +
                "    \"orderId\": 12050767490139,\n" +
                "    \"status\": \"EM_ANALISE_MANUAL\",\n" +
                "    \"shoppingCartId\": 7878502,\n" +
                "    \"orderTotalValue\": 180.31,\n" +
                "    \"subsidiary\": 507,\n" +
                "    \"urgentOrder\": false,\n" +
                "    \"orderType\": \"DIGITAL\",\n" +
                "    \"orderSource\": \"ECOMMERCE\",\n" +
                "    \"operationCode\": 826,\n" +
                "    \"signatureId\": 7714849,\n" +
                "    \"covenants\": [],\n" +
                "    \"client\": {\n" +
                "        \"code\": 5855628,\n" +
                "        \"areaCode\": \"51\",\n" +
                "        \"phoneNumber\": \"999999999\"\n" +
                "    },\n" +
                "    \"paymentMethods\": [\n" +
                "        {\n" +
                "            \"paymentMethodDescription\": \"CARTAO_ONLINE_A_VISTA\",\n" +
                "            \"paymentType\": \"P\",\n" +
                "            \"value\": 180.31,\n" +
                "            \"paymentMethodSequence\": 1,\n" +
                "            \"paymentConditionCode\": 2,\n" +
                "            \"paymentConditionSequence\": 2,\n" +
                "            \"covenantSubsidiaryCode\": 1002,\n" +
                "            \"covenantCode\": 254525,\n" +
                "            \"covenantDocuments\": [],\n" +
                "            \"transactionUSN\": \"000090242   \",\n" +
                "            \"authorizationNumber\": \"090242\",\n" +
                "            \"cardId\": 514947,\n" +
                "            \"nitEsitef\": \"1fc3779145bad0e296322b7b38e8d090c1b5370ed51cffc1ac2daec55bccd3d5\",\n" +
                "            \"cardHash\": \"Wy50Ya+m62en1DlLJvgdw-NJNClAQRsxMoJ3l+SpAC0FtHiFJUlvvaG2biSB5iSFJNuw4m-Ef5ioO4jxg5iFTw==\",\n" +
                "            \"authorizerId\": 2,\n" +
                "            \"installmentType\": 4,\n" +
                "            \"installments\": 1,\n" +
                "            \"businessPaperTypeCode\": 30\n" +
                "        }\n" +
                "    ],\n" +
                "    \"feeItem\": {\n" +
                "        \"itemCode\": 806190,\n" +
                "        \"amount\": 1,\n" +
                "        \"unitaryValue\": 40.33,\n" +
                "        \"totalValue\": 40.33\n" +
                "    },\n" +
                "    \"splittedOrder\": false,\n" +
                "    \"nitEsitef\": \"1fc3779145bad0e296322b7b38e8d090c1b5370ed51cffc1ac2daec55bccd3d5\"\n" +
                "}";
        return CucumberUtils.getObjectBodyFromJson(body, PostOrderRequest_v1.class);
    }

    public static PostOrderRequest_v1 analiseManual() throws JsonProcessingException {
        String body = "{\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"code\": 115346,\n" +
                "            \"number\": 0,\n" +
                "            \"deliveryId\": \"123456\",\n" +
                "            \"amount\": 1,\n" +
                "            \"deliveryAmount\": 1,\n" +
                "            \"unitaryValue\": 66.99,\n" +
                "            \"totalValue\": 40.49,\n" +
                "            \"contemplatedByCovenant\": false,\n" +
                "            \"discount\": {\n" +
                "                \"discountValue\": 26.5,\n" +
                "                \"discountType\": \"I\",\n" +
                "                \"discountPercentage\": 39.56,\n" +
                "                \"discountOrigin\": \"PROMOCAO\"\n" +
                "            },\n" +
                "            \"promotion\": {\n" +
                "                \"code\": 117171,\n" +
                "                \"subsidiaryCode\": 1002\n" +
                "            },\n" +
                "            \"pbmAuthorizations\": [],\n" +
                "            \"typedItem\": false\n" +
                "        }\n" +
                "    ],\n" +
                "    \"delivery\": {\n" +
                "        \"id\": \"123456\",\n" +
                "        \"subsidiary\": 389,\n" +
                "        \"deliveryType\": \"LOCKER\",\n" +
                "        \"deliveryDate\": \"2021-03-09T22:21\",\n" +
                "        \"feeCode\": 0,\n" +
                "        \"feeValue\": 0,\n" +
                "        \"coveredByCovenant\": false,\n" +
                "        \"lockerId\": 1,\n" +
                "        \"lockerDoorNumber\": 7011,\n" +
                "        \"lockerReserveNumber\": \"10040094\",\n" +
                "        \"lockerReservePassword\": \"NzY5Mg==\",\n" +
                "        \"address\": {\n" +
                "            \"localityCode\": 7394,\n" +
                "            \"streetCode\": 355879,\n" +
                "            \"number\": 865\n" +
                "        },\n" +
                "        \"chargeFee\": false\n" +
                "    },\n" +
                "    \"orderId\": 84110996,\n" +
                "    \"status\": \"EM_ANALISE_MANUAL\",\n" +
                "    \"shoppingCartId\": 5939210,\n" +
                "    \"orderTotalValue\": 40.49,\n" +
                "    \"subsidiary\": 389,\n" +
                "    \"urgentOrder\": false,\n" +
                "    \"orderType\": \"DIGITAL\",\n" +
                "    \"orderSource\": \"ECOMMERCE\",\n" +
                "    \"operationCode\": 826,\n" +
                "    \"covenants\": [\n" +
                "        {\n" +
                "            \"code\": 412104,\n" +
                "            \"associateRegistration\": \"99000212\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"code\": 414000,\n" +
                "            \"associateRegistration\": \"1686401043\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"code\": 416061,\n" +
                "            \"associateRegistration\": \"1686401043\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"code\": 473065,\n" +
                "            \"associateRegistration\": \"1686401043\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"client\": {\n" +
                "        \"code\": 5855628,\n" +
                "        \"name\": \"VINICIUS CORREA ZMUDA\",\n" +
                "        \"areaCode\": \"51\",\n" +
                "        \"phoneNumber\": \"994113813\",\n" +
                "        \"document\": \"00415559022\",\n" +
                "        \"trackingDdd\": \"51\",\n" +
                "        \"trackingPhone\": \"994113813\"\n" +
                "    },\n" +
                "    \"paymentMethods\": [\n" +
                "        {\n" +
                "            \"paymentMethodDescription\": \"CARTAO_ONLINE_A_VISTA\",\n" +
                "            \"paymentType\": \"P\",\n" +
                "            \"value\": 40.49,\n" +
                "            \"paymentMethodSequence\": 1,\n" +
                "            \"paymentConditionCode\": 2,\n" +
                "            \"paymentConditionSequence\": 3,\n" +
                "            \"covenantSubsidiaryCode\": 1002,\n" +
                "            \"covenantCode\": 254487,\n" +
                "            \"covenantDocuments\": [],\n" +
                "            \"transactionUSN\": \"000095485   \",\n" +
                "            \"authorizationNumber\": \"808750\",\n" +
                "            \"cardId\": 794508,\n" +
                "            \"nitEsitef\": \"44fc7922b48591f188f5cf6f16cd5c26f01c6ee597a4328b97fd6c79425d13c4\",\n" +
                "            \"installmentType\": 4,\n" +
                "            \"installments\": 1,\n" +
                "            \"businessPaperTypeCode\": 30\n" +
                "        }\n" +
                "    ],\n" +
                "    \"splittedOrder\": false,\n" +
                "    \"nitEsitef\": \"44fc7922b48591f188f5cf6f16cd5c26f01c6ee597a4328b97fd6c79425d13c4\"\n" +
                "}";
        return CucumberUtils.getObjectBodyFromJson(body, PostOrderRequest_v1.class);
    }

}
