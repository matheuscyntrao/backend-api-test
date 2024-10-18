package model.digital.entrega.v3.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLockerWebhook {
    private String placeName;
    private Integer lockerNumber;
    private String bookingNumber;
    private String document;
    private String status;
    private String updatedAt;
}
