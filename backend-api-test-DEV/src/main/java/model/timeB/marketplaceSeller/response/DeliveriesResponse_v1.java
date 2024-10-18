package model.timeB.marketplaceSeller.response;

import lombok.Data;

import java.util.List;

@Data
public class DeliveriesResponse_v1 {
    private List<DeliveriesResponse_v1_Shipping> shippingQuotes;
    private String namespace;
    private String language;
}
