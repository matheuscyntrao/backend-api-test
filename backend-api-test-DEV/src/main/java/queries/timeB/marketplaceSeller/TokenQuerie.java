package queries.timeB.marketplaceSeller;

import com.epam.reportportal.service.ReportPortal;
import entity.marketplaceSeller.TokenEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class TokenQuerie extends BaseQueries {
    public static List<TokenEntity> getToken() {
        String SQL = "SELECT ELS.USER_EMAIL AS userEmail,\n" +
                "ELS.API_KEY AS apiKey,\n" +
                "ELS.ACCOUNTMANAGER_KEY AS accountmanagerKey,\n" +
                "ELS.BEARER_TOKEN AS bearerToken,\n" +
                "ELS.EXPIRACAO_TOKEN AS expiracaoToken,\n" +
                "ELS.DATA_LOGIN AS dataLogin\n" +
                "FROM PROECM.ECM_LOGIN_SKYHUB ELS";
        List<TokenEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(TokenEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void updateTokenToExpired() {
        String SQL = "UPDATE PROECM.ECM_LOGIN_SKYHUB ELS " +
                "SET ELS.EXPIRACAO_TOKEN = SYSDATE - 1/24 " +
                "WHERE 1=1";
        getTemplate().execute(SQL);
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
    }

    public static void updateTokenToValid() {
        String SQL = "UPDATE PROECM.ECM_LOGIN_SKYHUB ELS" +
                " SET ELS.EXPIRACAO_TOKEN = SYSDATE + 6/24 " +
                "WHERE 1=1";
        getTemplate().execute(SQL);
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
    }

    public static void updateToken(String token) {
        if (token.equals("valido")) {
            updateTokenToValid();
        } else {
            updateTokenToExpired();
        }
    }

    public static void main(String[] args) {
        List<TokenEntity> querieResult = getToken();
        updateTokenToExpired();
        List<TokenEntity> querieResult2 = getToken();
        System.out.println(querieResult);
    }
}
