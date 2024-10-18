package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.LockerEntity;
import utils.database.MongoDatastore;

public class LockerDatastore extends MongoDatastore {

    public LockerDatastore() {
        super("mongo.shopping-cart");
    }

    public LockerEntity getLockerByLockerName(String lockerName) {
        return datastore.createQuery(LockerEntity.class)
                .field("lockerName").equalIgnoreCase(lockerName)
                .get();
    }
}
