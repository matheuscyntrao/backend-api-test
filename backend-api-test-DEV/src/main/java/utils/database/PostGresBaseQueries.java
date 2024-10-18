package utils.database;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class PostGresBaseQueries {

    private static final PostgresConnection connection = new PostgresConnection();
    private static final JdbcTemplate template = new JdbcTemplate(connection.connectJDBC("coupon_db_hml"));


    public PostgresConnection getConnection() {
        return connection;
    }

    protected static JdbcTemplate getTemplate() {
        return template;
    }
}
