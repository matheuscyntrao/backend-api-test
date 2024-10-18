package dataSource.mongo.shoppingCart;

import entity.domino.puc.ItemsValidatorEntity;
import utils.database.MongoDatastore;

public class PucDatastore extends MongoDatastore {

    public PucDatastore() {
        super("mongo.puc-service");
    }

    public ItemsValidatorEntity getItem(Long code) {
        return datastore.createQuery(ItemsValidatorEntity.class)
                .field("document").equalIgnoreCase("02625339012")
                .field("code").equal(code)
                .field("wallet.exclusionDate").doesNotExist()
                .get();
    }
    public ItemsValidatorEntity getRandomItem() {
        return datastore.createQuery(ItemsValidatorEntity.class)
                .field("wallet.exclusionDate").doesNotExist()
                .field("wallet").exists()
                .get();
    }
    public ItemsValidatorEntity getRandomInvalidItem() {
        return datastore.createQuery(ItemsValidatorEntity.class)
                .field("wallet.exclusionDate").exists()
                .field("wallet").exists()
                .get();
    }
//    public ItemsValidatorEntity getRandomInvalidClient() {
//        return datastore.createQuery(ItemsValidatorEntity.class)
//                .field("exclusionDate").exists()
//                .get();
//    }
}
