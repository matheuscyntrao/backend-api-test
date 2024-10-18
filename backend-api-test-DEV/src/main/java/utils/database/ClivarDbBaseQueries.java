package utils.database;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class ClivarDbBaseQueries {

    private static final ClivarDbConnection connection = new ClivarDbConnection();
    private static final JdbcTemplate template = new JdbcTemplate(connection.connectJDBC());

    public ClivarDbConnection getConnection() {
        return connection;
    }

    protected static JdbcTemplate getTemplate() {
        return template;
    }
}
