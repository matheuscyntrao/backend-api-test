package enums.time_b.rappi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.rappi.request.PostOrderRequestV1Delivery;

@AllArgsConstructor
@Getter
public enum OrderDelivery {
    ORDER_DELIVERY {
        @Override
        public PostOrderRequestV1Delivery pojo() {
            //TODO validar intervalo entre as datas, formato da data: Format simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            return PostOrderRequestV1Delivery.builder()
                    .deliveryTime("2021-02-02T19:26:07.788Z")
                    .departureTime("2021-02-02T19:26:07.788Z")
                    .build();
        }
    };

    public abstract PostOrderRequestV1Delivery pojo();
}