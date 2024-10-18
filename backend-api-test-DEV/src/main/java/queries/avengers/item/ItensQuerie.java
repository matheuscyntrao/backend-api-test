package queries.avengers.item;

import com.epam.reportportal.service.ReportPortal;
import entity.avangers.item.MedidaItemEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class ItensQuerie extends BaseQueries {
    public static List<String> getTiposItem(String item) {
        String SQL = String.format("select distinct %s\n" +
                "  from phw_dados_itens dad\n" +
                " where dad.ativo = 'S'\n" +
                "   and %s != 'NAO DEFINIDO'", item, item);
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }
    public static MedidaItemEntity getMedidaItem(Integer codigoItem) {
        String SQL = String.format("SELECT peso, \n" +
                "       volume,  \n" +
                "       altura, \n" +
                "       largura, \n" +
                "       comprimento \n" +
                "FROM   unidades_de_medida_do_item \n" +
                "WHERE  codigo_do_item = %d", codigoItem);
        List<MedidaItemEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(MedidaItemEntity.class));
        return result.get(0);
    }

    public static void main(String[] args) {
       List<String> nomenclatura_varejo =  getTiposItem("nomenclatura_varejo");
       List<String> razao_social_do_fornecedor =  getTiposItem("razao_social_do_fornecedor");
       List<String> descricao_do_tipo_do_item =  getTiposItem("descricao_do_tipo_do_item");
       List<String> descricao_do_grupo_de_item =  getTiposItem("descricao_do_grupo_de_item");
       List<String> descr_subgrupo_item =  getTiposItem("descr_subgrupo_item");
       List<String> descricao_da_categoria_do_item =  getTiposItem("descricao_da_categoria_do_item");
       List<String> descricao_da_categoria_pai =  getTiposItem("descricao_da_categoria_pai");
       List<String> descricao_da_marca_do_item =  getTiposItem("descricao_da_marca_do_item");
       List<String> descricao_da_marca_pai =  getTiposItem("descricao_da_marca_pai");
       List<String> descr_da_classe_terapeutica =  getTiposItem("descr_da_classe_terapeutica");
       List<String> descricao_do_nome_generico =  getTiposItem("descricao_do_nome_generico");
       List<String> voltagem =  getTiposItem("voltagem");
       List<String> tipo_pele =  getTiposItem("tipo_pele");
       System.out.println(nomenclatura_varejo);
    }


}
