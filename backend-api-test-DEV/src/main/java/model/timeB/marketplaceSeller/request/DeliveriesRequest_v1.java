package model.timeB.marketplaceSeller.request;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class DeliveriesRequest_v1 {
    private Integer destinationZip;
    private List<DeliveriesRequest_v1_Volume> volumes;

}
