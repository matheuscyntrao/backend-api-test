package model.timeB.marketplaceSeller.request;

import lombok.Data;

@Data
public class DeliveriesRequest_v1_Volume {
    private String sku;
    private Integer quantity;
    private Double price;
    private Double height;
    private Double length;
    private Double width;
    private Double weight;

}
