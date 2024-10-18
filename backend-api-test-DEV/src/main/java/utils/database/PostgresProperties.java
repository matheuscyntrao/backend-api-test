package utils.database;

import utils.PropertiesReader;

import java.util.Properties;

public class PostgresProperties {

    private static final Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static final String prefixo = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static String host = System.getenv("POSTGRES_HOST") != null ? System.getenv("POSTGRES_HOST") : props.getProperty(prefixo.concat(".POSTGRESTST.url"));
    public static String port = System.getenv("POSTGRES_PORT") != null ? System.getenv("POSTGRES_PORT") : props.getProperty(prefixo.concat(".POSTGRESTST.port"));
    public static String user = System.getenv("POSTGRES_USERNAME") != null ? System.getenv("POSTGRES_USERNAME") : props.getProperty(prefixo.concat(".POSTGRESTST.user"));
    public static String password = System.getenv("POSTGRES_PASSWORD") != null ? System.getenv("POSTGRES_PASSWORD") : props.getProperty(prefixo.concat(".POSTGRESTST.password"));
}
