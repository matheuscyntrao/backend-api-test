package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.PickupSubsidiaryEntity;
import org.bson.types.ObjectId;
import utils.database.MongoDatastore;

public class PickupSubsidiaryDatastore extends MongoDatastore {

    public PickupSubsidiaryDatastore() {
        super("mongo.shopping-cart");
    }

    public PickupSubsidiaryEntity getPickupSubsidiaryById(String id) {
        ObjectId oid = new ObjectId(id);
        return datastore.createQuery(PickupSubsidiaryEntity.class)
                .field("_id").equal(oid)
                .get();
    }

    public void deleteById(String id) {
        datastore.delete(this.getPickupSubsidiaryById(id));
    }

}
