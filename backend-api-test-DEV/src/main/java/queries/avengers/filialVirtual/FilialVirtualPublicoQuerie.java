package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Filial;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Publico;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualPublicoQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Publico> getPublicos() {
        String SQL = "" +
                "Select Distinct Vcc.Valor_Da_Classificacao tipoPublico \n" +
                "  From Cor_Tipos_Classificacoes_Cli Tcc\n" +
                "      ,Cor_Valores_Classif_Clientes Vcc\n" +
                " Where Tcc.Nome_Da_Classificacao = 'TIPO_DE_PUBLICO'\n" +
                "   And Tcc.Codigo_Da_Classificacao = Vcc.Codigo_Da_Classificacao\n" +
                "   And Exists (Select 1\n" +
                "          From Parametros_Das_Filiais Par\n" +
                "         Where 1 = 1 \n" +
                "           And Par.Codigo_Da_Filial = Vcc.Codigo_Da_Entidade_Comercial)\n" +
                " Order By 1 \n";

        List<FilialVirtualResponse_v1_Publico> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Publico.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Publico> getPublicosResult = getPublicos();
        System.out.println(getPublicosResult);
    }
}
