package model.crossover.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderRequest_v1_Delivery_Address {
    private Long localityCode;
    private Long streetCode;
    private Integer number;
    private String complement;
    private String deliveryReference;
    private String uf;
    private String city;
    private String district;
    private String street;
    private Long zipCode;
    private String ibgeCityCode;
    private String provinceName;
    private String countryCode;
    private String countryAcronym;
    private String countryName;
    private String streetType;
}
