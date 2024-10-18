package utils.properties;

import utils.PropertiesReader;

import java.util.Properties;

public class MateraProperties {
    private static final Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static final String prefixo = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static String apiAccessKey = System.getenv("API_ACCESSKEY") != null ? System.getenv("API_ACCESSKEY") : props.getProperty(prefixo.concat(".API.accesskey"));
}
