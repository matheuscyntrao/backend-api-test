package queries.timeB.marketplaceSeller;

import com.epam.reportportal.service.ReportPortal;
import entity.marketplaceSeller.ProductsToInsertOrUpdateEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ProductsToInsertOrUpdateQuerie extends BaseQueries {

    public static ProductsToInsertOrUpdateEntity getProductToInsertOrUpdate(String product) {
        String SQL = String.format("select XX.CODIGO_DO_ITEM, XX.ID_HUB_MARKETPLACE, XX.ACAO\n" +
                "  from (select EII.CODIGO_DO_ITEM,\n" +
                "               EHM.ID_HUB_MARKETPLACE,\n" +
                "               nvl((select decode(EIM.DATA_EXCLUSAO, null, 'OK', 'UPDATE')\n" +
                "                     from ECM_ITENS_MARKETPLACE EIM\n" +
                "                    where EIM.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM),\n" +
                "                   'INSERT') ACAO\n" +
                "          from ECM_ITENS_DA_INTERNET      EII,\n" +
                "               UNIDADES_DE_MEDIDA_DO_ITEM UMI,\n" +
                "               ITENS                      IT,\n" +
                "               ECM_HUBS_MARKETPLACE       EHM\n" +
                "         where UMI.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM\n" +
                "           and IT.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM\n" +
                "           and IT.DATA_DE_EXCLUSAO is null\n" +
                "           and EII.ITEM_BLOQUEADO = 'N'\n" +
                "           and EII.CODIGO_DO_ITEM in\n" +
                "               (select PDI.CODIGO_DO_ITEM\n" +
                "                  from PHW_DADOS_ITENS PDI\n" +
                "                 where nvl(PDI.ATIVO, 'S') = 'S'\n" +
                "                   and PDI.CODIGO_DO_ITEM in\n" +
                "                       (Select ITE.CODIGO_DO_ITEM OTC\n" +
                "                          from ITENS ITE\n" +
                "                         where INDICADOR_OTC = 'S'\n" +
                "                           and ITE.DATA_DE_EXCLUSAO is null\n" +
                "                        union\n" +
                "                        select ITE.CODIGO_DO_ITEM OTC\n" +
                "                          from ITENS          ITE,\n" +
                "                               GRUPOS_DE_ITEM GDI,\n" +
                "                               TIPOS_DO_ITEM  TDI\n" +
                "                         where GDI.CODIGO_DO_GRUPO_DE_ITEM = ITE.CODIGO_DO_GRUPO_DE_ITEM\n" +
                "                           and GDI.CODIGO_DO_TIPO_DO_ITEM = TDI.CODIGO_DO_TIPO_DO_ITEM\n" +
                "                           and ITE.DATA_DE_EXCLUSAO is null\n" +
                "                           and TDI.CODIGO_DO_TIPO_DO_ITEM = 2))) XX\n" +
                " where XX.ACAO in ('INSERT', 'UPDATE')\n" +
                " AND CODIGO_DO_ITEM = %s\n" +
                " order by XX.ACAO", product);
        List<ProductsToInsertOrUpdateEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ProductsToInsertOrUpdateEntity.class));
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        return result.get(0);
    }

    public static Integer getIdHubMarketplace(String product) {
        String SQL = String.format("SELECT eim.ID_HUB_MARKETPLACE " +
                "FROM PROECM.ECM_ITENS_MARKETPLACE eim " +
                "WHERE eim.CODIGO_DO_ITEM = %s", product);
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static void insertProduct(ProductsToInsertOrUpdateEntity products) {
        String SQL = String.format("insert into ECM_ITENS_MARKETPLACE EIM\n" +
                "      (ID_ITEM_MARKETPLACE\n" +
                "      ,ID_HUB_MARKETPLACE\n" +
                "      ,CODIGO_DO_ITEM\n" +
                "      ,DATA_INCLUSAO\n" +
                "      ,DATA_EXCLUSAO)\n" +
                "values(ITEMAR_ID_ITEM_MARKETPLACE_SQ.nextval\n" +
                "      ,%s\n" +
                "      ,%s\n" +
                "      ,sysdate\n" +
                "      ,null)", products.getId_hub_marketplace(), products.getCodigo_do_item());
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        getTemplate().execute(SQL);
    }

    public static void updateProduct(ProductsToInsertOrUpdateEntity products) {
        String SQL = String.format("update ECM_ITENS_MARKETPLACE EIM\n" +
                "   set EIM.DATA_EXCLUSAO = null\n" +
                " where EIM.CODIGO_DO_ITEM =  %s\n" +
                "   and EIM.ID_HUB_MARKETPLACE = %s\n", products.getCodigo_do_item(), products.getId_hub_marketplace());
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        getTemplate().execute(SQL);
    }

    public static void deleteOneProduct(String product, String idHubMarketplace) {
        String SQL = String.format("DELETE FROM ECM_ITENS_MARKETPLACE eim " +
                "WHERE CODIGO_DO_ITEM = %s " +
                "AND ID_HUB_MARKETPLACE = %s", product, idHubMarketplace);
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        getTemplate().execute(SQL);
    }

    public static void updateOneProduct(String product, String idHubMarketplace) {
        String SQL = String.format("UPDATE ECM_ITENS_MARKETPLACE eim" +
                " SET eim.DATA_EXCLUSAO = SYSDATE" +
                " WHERE CODIGO_DO_ITEM = %s" +
                " AND ID_HUB_MARKETPLACE = %s", product, idHubMarketplace);
        ReportPortal.emitLog(SQL, "INFO", Date.from(Instant.now()));
        getTemplate().execute(SQL);
    }

    public static void prepareForAutomation(String scenario, String product) {
        Integer idHubMarketplace = getIdHubMarketplace(product);
        if (scenario.equals("INSERT")) {
            deleteOneProduct(product, idHubMarketplace.toString());
        } else {
            updateOneProduct(product, idHubMarketplace.toString());
        }
    }

    public static void executeOperation(String product) {
        ProductsToInsertOrUpdateEntity products = ProductsToInsertOrUpdateQuerie.getProductToInsertOrUpdate(product);
        if (products.getAcao().equals("INSERT")) {
            insertProduct(products);
        } else {
            updateProduct(products);
        }
    }
}
