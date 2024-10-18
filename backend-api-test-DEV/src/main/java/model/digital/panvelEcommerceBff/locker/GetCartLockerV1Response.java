package model.digital.panvelEcommerceBff.locker;

import lombok.Data;
import model.digital.panvelEcommerceBff.locker.orm.Locker;

import java.util.List;

@Data
public class GetCartLockerV1Response {
    private List<Locker> lockers;
    private Long shipment;
}
