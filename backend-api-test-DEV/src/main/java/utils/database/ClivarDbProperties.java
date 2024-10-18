package utils.database;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import utils.PropertiesReader;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClivarDbProperties {

    private static final Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static final String PREFIXO = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static final String url = System.getenv("CLIVARDB_HOST") != null ? System.getenv("CLIVARDB_HOST") : props.getProperty(PREFIXO.concat(".CLIVARDB.url"));
    public static final String port = System.getenv("CLIVARDB_PORT") != null ? System.getenv("CLIVARDB_PORT") : props.getProperty(PREFIXO.concat(".CLIVARDB.port"));
    public static final String user = System.getenv("CLIVARDB_USERNAME") != null ? System.getenv("CLIVARDB_USERNAME") : props.getProperty(PREFIXO.concat(".CLIVARDB.user"));
    public static final String password = System.getenv("CLIVARDB_PASSWORD") != null ? System.getenv("CLIVARDB_PASSWORD") : props.getProperty(PREFIXO.concat(".CLIVARDB.password"));
    public static final String sid = System.getenv("CLIVARDB_SID") != null ? System.getenv("CLIVARDB_SID") : props.getProperty(PREFIXO.concat(".CLIVARDB.SID"));

}
