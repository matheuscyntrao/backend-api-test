package entity.digital.shoppingCart;

import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;

@Entity("Locker")
@Data
public class LockerEntity {
    @Id
    private Long id;
    private Long lockerModelId;
    private Long lockerNumber;
    private String lockerName;
    private String lockerFriendlyName;
    private Instant startDate;
    private Instant finalDate;
    private Long operationIndicator;
    private Double coordinates[];
    private Long supplySubsidiary;
    private LockerEntity_Address address[];

}

@Data
class LockerEntity_Address {
    private Long localeCode;
    private Long streetCode;
    private String streetType;
    private String streetName;
    private Long addressNumber;
    private String complement;
    private String neighborhood;
    private String zipCode;
    private String localeName;
    private String state;
    private String country;
}
