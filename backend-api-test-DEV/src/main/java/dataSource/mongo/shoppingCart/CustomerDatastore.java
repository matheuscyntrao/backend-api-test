package dataSource.mongo.shoppingCart;

import entity.digital.shoppingCart.CustomerEntity;
import utils.database.MongoDatastore;

public class CustomerDatastore extends MongoDatastore {

    public CustomerDatastore() {
        super("mongo.shopping-cart");
    }

    public CustomerEntity getCustomerByCpf(String cpf) {
        return datastore.createQuery(CustomerEntity.class)
                .field("cpf").equalIgnoreCase(cpf)
                .get();
    }


}
