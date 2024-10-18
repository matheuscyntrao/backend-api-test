package utils.database;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.TimeZone;

public class BankAccountConnection {

    public DataSource connectJDBC() {
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        TimeZone.setDefault(timeZone);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(this.getConnectionString());
        dataSource.setUsername(BankAccountProperties.user);
        dataSource.setPassword(BankAccountProperties.password);
        return dataSource;
    }

    public String getConnectionString() {
        return String.format("jdbc:postgresql://%s:%s/%s", BankAccountProperties.url, BankAccountProperties.port, BankAccountProperties.database);
    }
}
