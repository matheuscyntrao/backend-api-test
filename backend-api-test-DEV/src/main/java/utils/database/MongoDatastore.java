package utils.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public abstract class MongoDatastore {
    public static Datastore datastore;

    protected MongoDatastore(String filePropertiesName, String prefix) {
        this(new MongoProperties(filePropertiesName, prefix));
    }

    protected MongoDatastore(String prefix) {
        this(new MongoProperties(prefix));
    }

    private MongoDatastore(MongoProperties properties) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI(properties.getUri()));
        Morphia morphia = new Morphia();
        morphia.mapPackage(properties.getModelsPackage());

        this.datastore = morphia.createDatastore(mongoClient, properties.getDatabase());
    }
}
