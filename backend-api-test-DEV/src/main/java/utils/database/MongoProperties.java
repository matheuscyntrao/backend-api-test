package utils.database;


import utils.PropertiesReader;

import java.util.Properties;

public class MongoProperties {
    private String database;
    private String uri;
    private String modelsPackage;

    public MongoProperties(String prefix) {
        this("database.properties", prefix);
    }

    public MongoProperties(String filePropertiesName, String prefix) {
        Properties properties = new PropertiesReader("src/main/resources/" + filePropertiesName).readProps();
        this.database = properties.getProperty(prefix + ".database");
        this.uri = String.format(properties.getProperty(prefix + ".uri"), new PropertiesReader("src/main/resources/environment.properties").readProps().getProperty("environment"));
        this.modelsPackage = "data.mongodb.model";
    }

    public String getDatabase() {
        return database;
    }

    public String getUri() {
        return uri;
    }

    public String getModelsPackage() {
        return modelsPackage;
    }
}
