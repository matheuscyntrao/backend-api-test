package utils.database;


import utils.PropertiesReader;
import utils.UriProperties;

import java.util.Properties;

public class DataBaseProperties {

    private static Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static String prefixo = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static String url = System.getenv("ORACLE_HOST") != null ? System.getenv("ORACLE_HOST") : props.getProperty(prefixo.concat(".CARTAOTST.url"));
    public static String port = System.getenv("ORACLE_PORT") != null ? System.getenv("ORACLE_PORT") : props.getProperty(prefixo.concat(".CARTAOTST.port"));
    public static String user = System.getenv("ORACLE_USERNAME") != null ? System.getenv("ORACLE_USERNAME") : props.getProperty(prefixo.concat(".CARTAOTST.user"));
    public static String password = System.getenv("ORACLE_PASSWORD") != null ? System.getenv("ORACLE_PASSWORD") : props.getProperty(prefixo.concat(".CARTAOTST.password"));
    public static String SID = System.getenv("ORACLE_SID") != null ? System.getenv("ORACLE_SID") : props.getProperty(prefixo.concat(".CARTAOTST.SID"));

}
