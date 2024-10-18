package utils;

import java.util.Properties;

public class UriProperties {
    static String caminhoURI = ClassLoader.getSystemResource("URI.properties").getPath();
    static String caminhoPrefixo = ClassLoader.getSystemResource("environment.properties").getPath();
    static String caminhoReportPortal = ClassLoader.getSystemResource("reportportal.properties").getPath();

    static Properties properties = new PropertiesReader(caminhoURI).readProps();
    static Properties environment = new PropertiesReader(caminhoPrefixo).readProps();
    static Properties reportPortal = new PropertiesReader(caminhoReportPortal).readProps();

    public static String prefixo = environment.getProperty("environment");
    public static Boolean local = Boolean.parseBoolean(environment.getProperty("local"));
    public static String url = properties.getProperty(prefixo + ".URL");
    public static String token = properties.getProperty(prefixo + ".TOKEN");
    public static String serviceName = reportPortal.getProperty("rp.launch");
}
