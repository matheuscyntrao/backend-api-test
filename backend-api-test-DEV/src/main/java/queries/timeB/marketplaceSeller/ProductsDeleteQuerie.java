package queries.timeB.marketplaceSeller;

import com.epam.reportportal.service.ReportPortal;
import entity.skyhub.ProductsDeleteEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ProductsDeleteQuerie extends BaseQueries {
    public static ProductsDeleteEntity getProductTODelete(String codigoItem) {
        String SQL = String.format("select eii.codigo_do_item codigoItem,\n" +
                "       it.data_de_exclusao dataExclusao,\n" +
                "       eii.item_bloqueado itemBloqueado,\n" +
                "       nvl(pdi.ativo, 'S') itemAtivo,\n" +
                "       (Select 'S'\n" +
                "          from itens ite\n" +
                "         where indicador_otc = 'S'\n" +
                "           and ite.codigo_do_item = eii.codigo_do_item) otc,\n" +
                "       (select 'S'\n" +
                "          from itens ite, grupos_de_item gdi, tipos_do_item tdi\n" +
                "         where gdi.codigo_do_grupo_de_item = ite.codigo_do_grupo_de_item\n" +
                "           and gdi.codigo_do_tipo_do_item = tdi.codigo_do_tipo_do_item\n" +
                "           and ite.data_de_exclusao is null\n" +
                "           and tdi.codigo_do_tipo_do_item = 2\n" +
                "           and ite.codigo_do_item = eii.codigo_do_item) HB\n" +
                "  from ecm_itens_da_internet eii\n" +
                "      ,ecm_itens_marketplace eim\n" +
                "      ,itens it\n" +
                "      ,phw_dados_itens pdi\n" +
                " where it.codigo_do_item  = eii.codigo_do_item\n" +
                "   and pdi.codigo_do_item = eii.codigo_do_item\n" +
                "   and eim.codigo_do_item = eii.codigo_do_item\n" +
                "   and eim.data_exclusao is null\n" +
                "   and eim.id_hub_marketplace = 1\n" +
                "  AND eim.codigo_do_item = %s", codigoItem);
        List<ProductsDeleteEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(ProductsDeleteEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result.get(0);
    }

    public static String getExclusionDate(String product){
        String SQL = String.format("SELECT DATA_EXCLUSAO \n" +
                "FROM PROECM.ECM_ITENS_MARKETPLACE eim \n" +
                "WHERE CODIGO_DO_ITEM = %s", product);
        return getTemplate().queryForObject(SQL, String.class);
    }

    public static void prepareProductToDelete(String product) {
        String SQL = String.format("update ecm_itens_marketplace eim\n" +
                "   set eim.data_exclusao = null\n" +
                " where eim.codigo_do_item = %s \n" +
                "   and eim.id_hub_marketplace = 1 \n", product);
        getTemplate().execute(SQL);
    }

    public static void main(String[] args) {
        System.out.println(getProductTODelete("76473"));
    }
}
