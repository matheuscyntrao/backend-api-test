package model.digital.panvelEcommerceBff.locker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCartLockerV1Request {
    private Long lockerId;
    private Long orderNumber;
}
