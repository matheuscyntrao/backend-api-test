package utils.database;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.TimeZone;

public class ClivarDbConnection {

    public DataSource connectJDBC() {
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        TimeZone.setDefault(timeZone);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl(this.getConnectionString());
        dataSource.setUsername(ClivarDbProperties.user);
        dataSource.setPassword(ClivarDbProperties.password);
        return dataSource;
    }

    public String getConnectionString() {
        return String.format("jdbc:oracle:thin:@%s:%s:%s", ClivarDbProperties.url, ClivarDbProperties.port, ClivarDbProperties.sid);
    }
}
