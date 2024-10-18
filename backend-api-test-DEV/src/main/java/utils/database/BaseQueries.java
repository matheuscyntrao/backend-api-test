package utils.database;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseQueries {

    private static final DataBaseConnection connection = new DataBaseConnection();
    private static final JdbcTemplate template = new JdbcTemplate(connection.connectJDBC());


    public DataBaseConnection getConnection() {
        return connection;
    }

    protected static JdbcTemplate getTemplate() {
        return template;
    }
}
