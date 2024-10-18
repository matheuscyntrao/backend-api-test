package dataProvider.digital.shipping;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import model.digital.shippingService.request.PostDeliveriesRequest_v1;
import model.digital.shippingService.request.PostDeliveriesRequest_v1_Address;
import model.digital.shippingService.request.PostDeliveriesRequest_v1_Customer;
import model.digital.shippingService.request.PostDeliveriesRequest_v1_Items;
import utils.CPF;
import utils.service.Cache;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public enum PostDeliverieRequestGenerate {
    SHIPPING_VALIDO {
        @Override
        public PostDeliveriesRequest_v1 pojo() {
            return PostDeliveriesRequest_v1.builder()
                    .address(PostDeliveriesRequest_v1_Address.generate())
                    .customer(PostDeliveriesRequest_v1_Customer.generate())
                    .items(PostDeliveriesRequest_v1_Items.generateList())
                    .date(LocalDate.now().plusDays(1L).toString().concat("T10:15:01"))
                    .operator(123456L)
                    .origin("STORE")
                    .build();
        }
    };

    public abstract PostDeliveriesRequest_v1 pojo();
}


