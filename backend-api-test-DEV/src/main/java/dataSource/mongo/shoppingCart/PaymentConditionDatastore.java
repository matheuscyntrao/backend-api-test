package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.LockerEntity;
import entity.digital.shoppingCart.PaymentConditionEntity;
import org.bson.types.ObjectId;
import utils.database.MongoDatastore;

public class PaymentConditionDatastore extends MongoDatastore {

    public PaymentConditionDatastore() {
        super("mongo.shopping-cart");
    }

    public PaymentConditionEntity getPaymentConditionById(String id) {
        ObjectId oid = new ObjectId(id);
        return datastore.createQuery(PaymentConditionEntity.class)
                .field("_id").equal(oid)
                .get();
    }


}
