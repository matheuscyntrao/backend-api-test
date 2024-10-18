package queries.timeB.marketplaceSeller;

import com.epam.reportportal.service.ReportPortal;
import entity.marketplaceSeller.ProductEntity;
import entity.marketplaceSeller.ProductMarketplaceEntity;
import entity.marketplaceSeller.ProductRuleEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ProductQuerie extends BaseQueries {
    public static ProductEntity getProductDetail(String codigoItem) {
        String SQL = String.format("SELECT\n" +
                "\tEII.CODIGO_DO_ITEM codigoItem,\n" +
                "\tUMI.PESO weight,\n" +
                "\tUMI.ALTURA height,\n" +
                "\tUMI.LARGURA width,\n" +
                "\tUMI.COMPRIMENTO length,\n" +
                "\tIT.DATA_DE_EXCLUSAO dataDeExclusao,\n" +
                "\tEII.DESCR_DETALHADA_MARKETPLACE descDetalhadaMarketplace,\n" +
                "\tEII.ITEM_BLOQUEADO itemBloqueado\n" +
                "FROM\n" +
                "\tECM_ITENS_DA_INTERNET EII\n" +
                "INNER JOIN ECM_ITENS_MARKETPLACE EIM \t\tON EII.CODIGO_DO_ITEM = EIM.CODIGO_DO_ITEM \n" +
                "\t\t\t\t\t\t\t\t\t\t\tAND EIM.DATA_EXCLUSAO IS NULL\n" +
                "\t\t\t\t\t\t\t\t\t\t\tAND EIM.ID_HUB_MARKETPLACE = 1\n" +
                "INNER JOIN UNIDADES_DE_MEDIDA_DO_ITEM UMI \tON UMI.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM\n" +
                "INNER JOIN ITENS IT \t\t\t\t\t\tON IT.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM\n" +
                "\t\t\t\t\t\t\t\t\t\t\tAND IT.DATA_DE_EXCLUSAO IS NULL\n" +
                "INNER JOIN PHW_DADOS_ITENS PDI\t\t\t\tON PDI.CODIGO_DO_ITEM = EII.CODIGO_DO_ITEM\n" +
                "\t\t\t\t\t\t\t\t\t\t   AND PDI.DESCRICAO_FORMA_ESP_ARMAZENAM != 'GELADEIRA'\n" +
                "WHERE\n" +
                "\t1 = 1\t\n" +
                "AND EII.ITEM_BLOQUEADO = 'N'\n" +
                "AND EII.CODIGO_DO_ITEM = %s", codigoItem);
        List<ProductEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ProductEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result.get(0);
    }

    public static ProductRuleEntity getPriceRule() {
        String SQL = "select ecm.tipo_preco AS tipoPreco          -- Indica o tipo de preço (De ou Por) que será utilizado na exportação do item para o Marketplace\n" +
                "      ,nvl(ecm.pe_acres_descr_preco, 0) AS peAcresDescrPreco -- Indica se existe algum percentual de acréscimo (positivo) ou decrescimo (negativo) a ser aplicado no preço do item a ser exportado\n" +
                "  from ecm_configuracoes_marketplace ecm\n" +
                " where sysdate between ecm.dt_inicial and nvl(ecm.dt_final, sysdate)";
        List<ProductRuleEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ProductRuleEntity.class));
        return result.get(0);
    }

    public static Integer countProductRows() {
        String SQL = "SELECT COUNT(1) FROM PROECM.ECM_ITENS_MARKETPLACE";
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static Integer countProductBkpRows() {
        String SQL = "SELECT COUNT(1) FROM PROECM.ECM_ITENS_MARKETPLACE_BKP";
        return getTemplate().queryForObject(SQL, Integer.class);
    }

    public static void deleteProductRows() {
        String SQL = "DELETE FROM PROECM.ECM_ITENS_MARKETPLACE WHERE 1 = 1";
        getTemplate().execute(SQL);
    }

    public static void deleteProduct(String codigoItem) {
        String SQL = String.format("DELETE FROM PROECM.ECM_ITENS_MARKETPLACE WHERE CODIGO_DO_ITEM = %s", codigoItem);
        getTemplate().execute(SQL);
    }

    public static void deleteProductBkpRows() {
        String SQL = "DELETE FROM PROECM.ECM_ITENS_MARKETPLACE_BKP WHERE 1 = 1";
        getTemplate().execute(SQL);
    }

    public static void insertOneProduct(String product) {
        String SQL = String.format("insert into proecm.ECM_ITENS_MARKETPLACE  \n" +
                "(select ID_ITEM_MARKETPLACE, ID_HUB_MARKETPLACE , CODIGO_DO_ITEM , DATA_INCLUSAO , DATA_EXCLUSAO from proecm.ECM_ITENS_MARKETPLACE_BKP WHERE codigo_do_item = %s)", product);
        getTemplate().execute(SQL);
    }

    public static void productsOriginalToBkp() {
        String SQL = "insert into proecm.ECM_ITENS_MARKETPLACE_BKP\n" +
                "(select ID_ITEM_MARKETPLACE, ID_HUB_MARKETPLACE , CODIGO_DO_ITEM , DATA_INCLUSAO , DATA_EXCLUSAO from proecm.ECM_ITENS_MARKETPLACE WHERE 1 = 1 )";
        getTemplate().execute(SQL);
    }

    public static void productsBkpToOriginal() {
        String SQL = "insert into proecm.ECM_ITENS_MARKETPLACE  \n" +
                "(select ID_ITEM_MARKETPLACE, ID_HUB_MARKETPLACE , CODIGO_DO_ITEM , DATA_INCLUSAO , DATA_EXCLUSAO from proecm.ECM_ITENS_MARKETPLACE_BKP WHERE 1 = 1 )";
        getTemplate().execute(SQL);
    }

    public static ProductMarketplaceEntity getProductMarketplace(String product){
        String SQL = String.format("SELECT ID_ITEM_MARKETPLACE AS idItemMarketplace,\n" +
                "ID_HUB_MARKETPLACE AS idHubMarketplace,\n" +
                "CODIGO_DO_ITEM AS codigoItem,\n" +
                "DATA_INCLUSAO AS dataInclusao,\n" +
                "DATA_EXCLUSAO AS dataExclusao\n" +
                "FROM PROECM.ECM_ITENS_MARKETPLACE eim WHERE eim.CODIGO_DO_ITEM = %s", product);
        List<ProductMarketplaceEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ProductMarketplaceEntity.class));
        return result.get(0);
    }

    public static void main(String[] args) {
//        //SETUP
//        assumingThat(countProductRows() > 1, () -> {
//            deleteProductBkpRows();
//            productsOriginalToBkp();
//        });
//
//        //EXECUCOES
//        //Esquema de cenario
//        deleteProductRows();
//        insertOneProduct("402732");
//
//        //TEARDOWN
//        assumingThat(countProductBkpRows() > 1, () -> {
//            deleteProductRows();
//            productsBkpToOriginal();
//        });
    }

}
