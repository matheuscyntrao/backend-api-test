package utils.database;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Locale;
import java.util.TimeZone;

public class PostgresConnection {

    public DataSource connectJDBC(String databaseName) {
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
        TimeZone.setDefault(timeZone);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(this.getConnectionString(databaseName));
        dataSource.setUsername(PostgresProperties.user);
        dataSource.setPassword(PostgresProperties.password);
        return dataSource;
    }

    public String getConnectionString(String databaseName) {
        return String.format("jdbc:postgresql://%s:%s/%s", PostgresProperties.host, PostgresProperties.port, databaseName);
    }
}
