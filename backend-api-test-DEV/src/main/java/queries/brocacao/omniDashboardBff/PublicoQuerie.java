package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class PublicoQuerie extends BaseQueries {
    public static List<String> getPublicos() {
        String SQL = "" +
                "Select Distinct Vcc.Valor_Da_Classificacao\n" +
                "  From Cor_Tipos_Classificacoes_Cli Tcc\n" +
                "      ,Cor_Valores_Classif_Clientes Vcc\n" +
                " Where Tcc.Nome_Da_Classificacao = 'TIPO_DE_PUBLICO'\n" +
                "   And Tcc.Codigo_Da_Classificacao = Vcc.Codigo_Da_Classificacao\n" +
                "   And Exists (Select 1\n" +
                "          From Parametros_Das_Filiais Par\n" +
                "         Where Par.Codigo_Da_Filial = Vcc.Codigo_Da_Entidade_Comercial)\n order By Vcc.Valor_Da_Classificacao";

        List<String> result = getTemplate().queryForList(SQL,String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> getPublicosResult = getPublicos();
        System.out.println(getPublicosResult);
    }
}
