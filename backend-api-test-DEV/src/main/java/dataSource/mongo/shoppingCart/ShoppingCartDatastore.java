package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.ShoppingCartEntity;
import org.bson.types.ObjectId;
import utils.database.MongoDatastore;

public class ShoppingCartDatastore extends MongoDatastore {

    public ShoppingCartDatastore() {
        super("mongo.shopping-cart");
    }

    public ShoppingCartEntity getShoppingCartById(String id) {
        ObjectId oid = new ObjectId(id);
        return datastore.createQuery(ShoppingCartEntity.class)
                .field("_id").equal(oid)
                .get();
    }

    public void deleteById(String id) {
        datastore.delete(this.getShoppingCartById(id));
    }
}
