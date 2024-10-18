package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Order {
    PEDIDO_SIMPLES {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SIMPLES.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery("2021-1-8T14:58:13.485234")
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_COM_DESCONTO {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITEM_COM_DESCONTO.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SIMPLES.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_DESCONTO.pojo());
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery("2021-1-8T14:58:13.485234")
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_COM_DESCONTO {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITEM_COM_DESCONTO.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SIMPLES.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_DESCONTO.pojo());
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery("2021-1-8T14:58:13.485234")
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_PROGRAMADA {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_PROGRAMADA_NOVO.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 1);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_PAC {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS_PAC.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 5);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_SEDEX {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS_SEDEX.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("SEDEX")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_LOCALIDADE {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_LOCALIDADE.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_SEM_MATCH {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SEM_MATCH.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_PROGRAMADA {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_PROGRAMADA_NOVO.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 1);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO_PROGRAMADA.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_PAC {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 5);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO_PROGRAMADA.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_SEDEX {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS_SEDEX.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO_PROGRAMADA.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("SEDEX")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_LOCALIDADE {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_LOCALIDADE.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 3);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO_PROGRAMADA.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_VALIDA_ALTERACAO_REGRA_PROGRAMADA_MOTOBOY {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_PROGRAMADA_NOVO.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 1);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_VALIDA_ALTERACAO_REGRA_CORREIOS_PAC  {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS_PAC.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 5);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("SEDEX")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_VALIDA_ALTERACAO_REGRA_CORREIOS_SEDEX  {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_CORREIOS_SEDEX.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_SIMPLES.pojo());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 2);
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery(calendar.getTime().toInstant().toString())
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(0.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_CADASTRADO_COM_JUROS {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SIMPLES.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_JUROS.pojo());
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery("2021-1-8T14:58:13.485234")
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(2.0)
                    .discount(0.0)
                    .build();
        }
    },
    PEDIDO_CLIENTE_NAO_CADASTRADO_COM_JUROS {
        @Override
        public OrderRequestDetails pojo() {
            List<OrderRequestItems> items = Arrays.asList(OrderItems.ITENS_SIMPLES.pojo());
            OrderRequestBillingAddress billingAddress = OrderBillingAddress.ENDERECOFATURA_SIMPLES.pojo();
            OrderRequestShippingAddress shippingAddress = OrderShippingAddress.ENDERECOENTREGA_SIMPLES.pojo();
            List<OrderRequestPayments> payment = Arrays.asList(OrderPayments.PAGAMENTO_JUROS.pojo());
            return OrderRequestDetails.builder()
                    .channel("AMERICANAS")
                    .items(items)
                    .customer(OrderCustomer.CLIENTE_NAO_CADASTRADO.pojo())
                    .billingAddresss(billingAddress)
                    .shippingAddress(shippingAddress)
                    .payments(payment)
                    .shippingMethod("PAC")
                    .shippingMethodId("8-CORREIOS")
                    .estimatedDelivery("2021-1-8T14:58:13.485234")
                    .shippingCost(0.0)
                    .calculationType("spreadsheet")
                    .interest(2.0)
                    .discount(0.0)
                    .build();
        }
    };

    public abstract OrderRequestDetails pojo();
}