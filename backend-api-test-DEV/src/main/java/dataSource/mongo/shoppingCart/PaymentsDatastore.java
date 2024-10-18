package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.PaymentConditionEntity;
import entity.digital.shoppingCart.PaymentsEntity;
import org.bson.types.ObjectId;
import utils.database.MongoDatastore;

public class PaymentsDatastore extends MongoDatastore {

    public PaymentsDatastore() {
        super("mongo.shopping-cart");
    }

    public PaymentsEntity getPaymentsById(String id) {
        ObjectId oid = new ObjectId(id);
        return datastore.createQuery(PaymentsEntity.class)
                .field("_id").equal(oid)
                .get();
    }

    public void deleteById(String id) {
        datastore.delete(this.getPaymentsById(id));
    }


}
