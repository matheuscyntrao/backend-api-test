package model.plataforma.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostPaymentHashRequest_v1_Order_DeliveryAddress {
    private String city;
    private String complement;
    private String district;
    private Integer number;
    private String street;
    private String uf;
    private String zipcode;
}
