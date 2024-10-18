package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.ShipmentEntity;
import org.bson.types.ObjectId;
import utils.database.MongoDatastore;

public class ShipmentDatastore extends MongoDatastore {

    public ShipmentDatastore() {
        super("mongo.shopping-cart");
    }

    public ShipmentEntity getShipmentById(String id) {
        ObjectId oid = new ObjectId(id);
        return datastore.createQuery(ShipmentEntity.class)
                .field("_id").equal(oid)
                .get();
    }


}
