package queries.timeB.marketplaceSeller;

import entity.marketplaceSeller.FreightTableEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class FreteQuerie extends BaseQueries {

    public static Integer getTotalFaixasCEP() {
        String SQL = "SELECT count(1) FROM PROECM.ECM_FAIXAS_CEP_MARKETPLACE efcm";
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static Integer getTotalFaixasPeso() {
        String SQL = "SELECT count(1) FROM PROECM.ECM_FAIXAS_PESO_MARKETPLACE efpm";
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static Integer getTotalFretes() {
        String SQL = "SELECT count(1) FROM PROECM.ECM_TABELA_FRETE_MARKETPLACE etfm";
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static FreightTableEntity getFreightData(String zipCode, String weight) {
        String SQL = String.format("SELECT ETFM.* FROM PROECM.ECM_TABELA_FRETE_MARKETPLACE etfm " +
                "INNER JOIN PROECM.ECM_FAIXAS_CEP_MARKETPLACE efcm " +
                "ON ETFM.ID_FAIXA_CEP = EFCM.ID_FAIXA_CEP " +
                "INNER JOIN PROECM.ECM_FAIXAS_PESO_MARKETPLACE efpm " +
                "ON ETFM.ID_FAIXA_PESO = EFPM.ID_FAIXA_PESO " +
                "WHERE %s BETWEEN EFCM.CEP_INICIAL AND EFCM.CEP_FINAL " +
                "AND %s BETWEEN EFPM.PESO_INICIAL AND EFPM.PESO_FINAL", zipCode, weight);
        List<FreightTableEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FreightTableEntity.class));
        return result.get(0);
    }
}
