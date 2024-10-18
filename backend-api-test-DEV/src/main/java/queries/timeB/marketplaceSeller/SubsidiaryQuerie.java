package queries.timeB.marketplaceSeller;

import com.epam.reportportal.service.ReportPortal;
import entity.marketplaceSeller.SubsidiaryEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class SubsidiaryQuerie extends BaseQueries {

    public static SubsidiaryEntity getSubsidiaryDetail(String codigoFilial) {
        String SQL = String.format("SELECT ID_FILIAL_MARKETPLACE idFilialMarketplace,\n" +
                "\t\tID_HUB_MARKETPLACE idHubMarketplace,\n" +
                "\t\tCODIGO_DA_FILIAL codigoFilial,\n" +
                "\t\tCONFIRMA_ESTOQUE confirmaEstoque,\n" +
                "\t\tEXPEDE_MERCADORIA expedeMercadoria,\n" +
                "\t\tPERCENTUAL_DE_ESTOQUE percentualEstoque,\n" +
                "\t\tQTD_MINIMA_ESTOQUE qtdMinimaEstoque,\n" +
                "\t\tDATA_DESATIVACAO dataDesativacao\n" +
                "FROM PROECM.ECM_FILIAIS_MARKETPLACE efm\n" +
                "WHERE CODIGO_DA_FILIAL = %s", codigoFilial);
        List<SubsidiaryEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(SubsidiaryEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result.get(0);
    }

    public static void main(String[] args) {
        SubsidiaryEntity querieResult = getSubsidiaryDetail("31");
        System.out.println(querieResult);
    }

}
