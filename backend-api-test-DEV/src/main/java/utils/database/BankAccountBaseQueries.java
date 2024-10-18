package utils.database;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BankAccountBaseQueries {

    private static final BankAccountConnection connection = new BankAccountConnection();
    private static final JdbcTemplate template = new JdbcTemplate(connection.connectJDBC());

    public BankAccountConnection getConnection() {
        return connection;
    }

    protected static JdbcTemplate getTemplate() {
        return template;
    }
}
