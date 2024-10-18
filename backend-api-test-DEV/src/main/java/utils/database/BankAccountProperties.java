package utils.database;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import utils.PropertiesReader;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccountProperties {

    private static final Properties props = new PropertiesReader(ClassLoader.getSystemResource("database.properties").getPath()).readProps();
    private static final String PREFIXO = new PropertiesReader(ClassLoader.getSystemResource("environment.properties").getPath()).readProps().get("environment").toString();
    public static final String url = System.getenv("BANKACCOUNT_HOST") != null ? System.getenv("BANKACCOUNT_HOST") : props.getProperty(PREFIXO.concat(".BANKACCOUNT.url"));
    public static final String port = System.getenv("BANKACCOUNT_PORT") != null ? System.getenv("BANKACCOUNT_PORT") : props.getProperty(PREFIXO.concat(".BANKACCOUNT.port"));
    public static final String user = System.getenv("BANKACCOUNT_USERNAME") != null ? System.getenv("BANKACCOUNT_USERNAME") : props.getProperty(PREFIXO.concat(".BANKACCOUNT.user"));
    public static final String password = System.getenv("BANKACCOUNT_PASSWORD") != null ? System.getenv("BANKACCOUNT_PASSWORD") : props.getProperty(PREFIXO.concat(".BANKACCOUNT.password"));
    public static final String database = System.getenv("BANKACCOUNT_DATABASE") != null ? System.getenv("BANKACCOUNT_DATABASE") : props.getProperty(PREFIXO.concat(".BANKACCOUNT.database"));

}
