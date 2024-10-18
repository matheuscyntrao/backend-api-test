package entity.digital.shoppingCart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;

@Data
@Entity("PickupSubsidiary")
public class PickupSubsidiaryEntity {
    @Id
    private ObjectId id;
    private String shipment;
    private PickupSubsidiaryEntity_Stores stores[];
}

@Data
class PickupSubsidiaryEntity_Stores {
    private Long subsidiaryCode;
    private Instant openingTime;
    private Instant closingTime;
    private String phone;
    private PickupSubsidiaryEntity_Stores_Address subsidiaryAddress;
    private String deliveryMethod;
}

@Data
class PickupSubsidiaryEntity_Stores_Address {
    private Long localityCode;
    private Long streetCode;
    private Double latitude;
    private Double longitude;
    private String streetType;
    private String street;
    private Long number;
    private String complement;
    private String zipCode;
    private String city;
    private String neighborhood;
    private String state;
}
