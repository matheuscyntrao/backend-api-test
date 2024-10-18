package entity.digital.shoppingCart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Data
@Entity("Shipment")
public class ShipmentEntity {
    @Id
    private ObjectId id;
    private String type;
    private String name;
    private String description;

}
