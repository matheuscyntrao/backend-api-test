package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class BairrosQuerie extends BaseQueries {
    public static List<String> getBairros() {
        String SQL = "Select Distinct Bar.Nome_Do_Bairro Bairro\n" +
                "  From Meios_De_Comunicacao      Mcom\n" +
                "      ,Enderecos_De_Entidade_Com Eent\n" +
                "      ,Logradouros               Log\n" +
                "      ,Localidades               Lc\n" +
                "      ,Entidades_Comerciais      Ent\n" +
                "      ,Bairros                   Bar\n" +
                "      ,Parametros_Das_Filiais    Pf\n" +
                " Where Eent.Codigo_Da_Entidade_Comercial = Mcom.Codigo_Da_Entidade_Comercial\n" +
                "   And Eent.Codigo_Do_Logradouro = Log.Codigo_Do_Logradouro\n" +
                "   And Log.Codigo_Da_Localidade = Lc.Codigo_Da_Localidade\n" +
                "   And Ent.Codigo_Da_Entidade_Comercial = Mcom.Codigo_Da_Entidade_Comercial\n" +
                "   And Lc.Sigla_Da_Uf = Ent.Sigla_Da_Uf\n" +
                "   And Lc.Codigo_Da_Localidade = Eent.Codigo_Da_Localidade\n" +
                "   And Bar.Codigo_Da_Localidade = Log.Codigo_Da_Localidade_Bairro\n" +
                "   And Bar.Codigo_Do_Bairro = Log.Codigo_Do_Bairro\n" +
                "   And Pf.Codigo_Da_Filial = Ent.Codigo_Da_Entidade_Comercial\n" +
                "   And Mcom.Codigo_Do_Tipo_De_Comunic = 13\n" +
                "   And Eent.Sequencia_Do_End_Da_Ent_Com =\n" +
                "       (Select Max(Sequencia_Do_End_Da_Ent_Com)\n" +
                "          From Enderecos_De_Entidade_Com\n" +
                "         Where Codigo_Da_Entidade_Comercial = Mcom.Codigo_Da_Entidade_Comercial)\n" +
                " Order By 1\n";
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> querieResult = getBairros();
        System.out.println(querieResult);
    }
}
