package utils.database;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Locale;
import java.util.TimeZone;

public class DataBaseConnection {

    private static DataBaseProperties props;
    private final Connection connection = null;

    public DataBaseConnection() {
        //connect();
    }

    Connection getConnection() {
        return connection;
    }

    public DataSource connectJDBC() {
        props = new DataBaseProperties();
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        TimeZone.setDefault(timeZone);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl(this.getConnectionString());
        dataSource.setUsername(props.user);
        dataSource.setPassword(props.password);
        return dataSource;
    }

    public String getConnectionString() {
        return String.format("jdbc:oracle:thin:@%s:%s:%s", props.url, props.port, props.SID);
    }
}
