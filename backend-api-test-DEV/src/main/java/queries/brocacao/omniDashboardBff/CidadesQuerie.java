package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import model.brocacao.omniDashboardBff.Coverage.CoverageValues;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CidadesQuerie extends BaseQueries {
    public static List<String> getCidades() {
       String SQL = "Select Distinct\n" +
               "      Loc.Nome_Da_Localidade\n" +
               " From Entidades_Comerciais          Enc\n" +
               "      ,Enderecos_De_Entidade_Com     Eec\n" +
               "      ,Enderecos_De_Ent_Com_Por_Tipo Etp\n" +
               "      ,Localidades                   Loc\n" +
               "      ,Logradouros                   Lgr\n" +
               "      ,Bairros                       Bai\n" +
               "      ,Filiais_Da_Area               Are\n" +
               "      ,Areas_De_Supervisao           Asu\n" +
               " Where Enc.Codigo_Da_Entidade_Comercial  = Eec.Codigo_Da_Entidade_Comercial\n" +
               "   And Eec.Codigo_Da_Entidade_Comercial  = Etp.Codigo_Da_Entidade_Comercial(+)\n" +
               "   And Eec.Sequencia_Do_End_Da_Ent_Com   = Etp.Sequencia_Do_End_Da_Ent_Com(+)\n" +
               "   And Eec.Codigo_Da_Localidade          = Loc.Codigo_Da_Localidade\n" +
               "   And Eec.Codigo_Da_Localidade          = Lgr.Codigo_Da_Localidade\n" +
               "   And Eec.Codigo_Do_Logradouro          = Lgr.Codigo_Do_Logradouro\n" +
               "   And Lgr.Codigo_Da_Localidade_Bairro   = Bai.Codigo_Da_Localidade\n" +
               "   And Lgr.Codigo_Do_Bairro              = Bai.Codigo_Do_Bairro\n" +
               "   And Enc.Codigo_Da_Entidade_Comercial  = Are.Codigo_Da_Filial\n" +
               "   And Are.Codigo_Da_Area_De_Supervisao  = Asu.Codigo_Da_Area_De_Supervisao\n" +
               "   And Etp.Codigo_Do_Tipo_De_Endereco    = 4\n" +
               "   And Enc.Codigo_Do_Distribuidor_Dimed Is Not Null\n" +
               " Order By 1\n";

        List<String> result = getTemplate().queryForList(SQL,String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> getCidadesResult = getCidades();
        System.out.println(getCidadesResult);
    }
}
