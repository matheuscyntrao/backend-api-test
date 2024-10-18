package dataProvider.domino;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.domino.order.request.PostEcommerceOrderRequest_v1;
import utils.CucumberUtils;

@Getter
@AllArgsConstructor
public enum OrderGenerate {
    ORDER_SIMPLES {
        @Override
        public PostEcommerceOrderRequest_v1 pojo() throws JsonProcessingException {
            return OrderGenerateDados.example();
        }
    };

    public abstract PostEcommerceOrderRequest_v1 pojo() throws JsonProcessingException;
}


class OrderGenerateDados {
    public static PostEcommerceOrderRequest_v1 example() throws JsonProcessingException {
        String body = "{\n" +
                "    \"signatureId\": 7714849,\n" +
                "    \"orderStatus\": \"PENDENTE\",\n" +
                "    \"subsidiary\": 507,\n" +
                "    \"shoppingCartId\": \"6081ae89436cd00001468aa0\",\n" +
                //"    \"orderType\": \"DIGITAL\",\n" +
                "    \"orderSource\": \"ECOMMERCE\",\n" +
                "    \"urgentOrder\": false,\n" +
                "    \"orderTotalValue\": 180.84,\n" +
                "    \"delivery\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"deliveryType\": \"RETIRADA_BALCAO\",\n" +
                "            \"deliveryMethod\": \"MOTOBOY\",\n" +
                "            \"feeCode\": 806190,\n" +
                "            \"feeValue\": 40.86,\n" +
                "            \"deliveryDate\": \"29/01/2021 00:01\",\n" +
                "            \"address\": {\n" +
                "                \"localityCode\": 9007,\n" +
                "                \"streetCode\": 762853,\n" +
                "                \"number\": 123,\n" +
                "                \"complement\": \"Apto 222\",\n" +
                "                \"deliveryReference\": \"Proximo a praça do centro\"" +
                "            },\n" +
                "            \"subsidiary\": 507\n" +
                "        }\n" +
                "    ],\n" +
                "    \"client\": {\n" +
                "        \"code\": 2020745,\n" +
                "        \"areaCode\": \"51\",\n" +
                "        \"phoneNumber\": \"999999999\"\n" +
                "    },\n" +
                "    \"paymentMethods\": [\n" +
                "        {\n" +
                "            \"cardId\": 513527,\n" +
                "            \"authorizerId\": 2,\n" +
                "            \"cvv\": 806,\n" +
                "            \"cardHash\": \"8BPWnjaI9uUOGnIu7SEI5YRNpz5L5+d3XmUGxKXGaR33XO2Tu8uxC0ZEQTHT4YIQUf+IUp+o4tAPY5JGMEvVFQ==\",\n" +
                "            \"installmentType\": 4,\n" +
                "            \"installments\": 1,\n" +
                "            \"paymentMethodDescription\": \"CARTAO_ONLINE_A_VISTA\",\n" +
                "            \"paymentType\": \"PRODUCT\",\n" +
                "            \"value\": 180.84,\n" +
                "            \"covenantSubsidiaryCode\": 1002,\n" +
                "            \"covenantCode\": 254525,\n" +
                "            \"paymentConditionCode\": 2,\n" +
                "            \"paymentConditionSequence\": 2\n" +
                "        }\n" +
                "    ],\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"code\": 502320,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 2,\n" +
                "            \"unitaryValue\": 69.99,\n" +
                "            \"totalValue\": 139.98,\n" +
                "            \"exemptionPercentage\": 6.67,\n" +
                "            \"promotion\": {\n" +
                "                \"subsidiaryCode\": 1002,\n" +
                "                \"code\": 108159\n" +
                "            },\n" +
                "            \"deliveryId\": 1\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return CucumberUtils.getObjectBodyFromJson(body, PostEcommerceOrderRequest_v1.class);
    }
}