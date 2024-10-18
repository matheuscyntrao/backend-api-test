package utils.properties;

import utils.PropertiesReader;

import java.util.Properties;

public class LoginTokenProperties {
    private static final Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static final String prefixo = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static String authorization = System.getenv("TOKEN_AUTH") != null ? System.getenv("TOKEN_AUTH") : props.getProperty(prefixo.concat(".TOKEN.authorization"));
    public static String username = System.getenv("TOKEN_USERNAME") != null ? System.getenv("TOKEN_USERNAME") : props.getProperty(prefixo.concat(".TOKEN.username"));
    public static String password = System.getenv("TOKEN_PASSWORD") != null ? System.getenv("TOKEN_PASSWORD") : props.getProperty(prefixo.concat(".TOKEN.password"));
    public static String apiKey = System.getenv("API_KEY") != null ? System.getenv("API_KEY") : props.getProperty(prefixo.concat(".API_KEY"));
    public static String secretKey = System.getenv("SECRET_KEY") != null ? System.getenv("SECRET_KEY") : props.getProperty(prefixo.concat(".SECRET_KEY"));
}
