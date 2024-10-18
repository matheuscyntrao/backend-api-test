package queries.timeB.ifood;

import entity.ifood.BearerTokenEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class GetClientTokenQuerie extends BaseQueries {
    public static BearerTokenEntity getClientIdAndSecretForToken() {
        String SQL = String.format("SELECT CLIENT_ID AS clientId, CLIENT_SECRET AS clientSecret FROM ECM_CREDENCIAL_MARKETPLACE");
        List<BearerTokenEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(BearerTokenEntity.class));
        return result.get(0);
    }
}
