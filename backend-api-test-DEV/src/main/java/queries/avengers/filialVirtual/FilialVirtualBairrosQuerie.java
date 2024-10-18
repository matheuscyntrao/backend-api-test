package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Bairro;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualBairrosQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Bairro> getBairros() {
        String SQL = "select Distinct Bai.Codigo_Da_Localidade codigoLocalidade\n" +
                "      ,Bai.Codigo_Do_Bairro codigoBairro\n" +
                "      ,Bai.Nome_Do_Bairro descricao\n" +
                "  From Entidades_Comerciais          Enc\n" +
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
        List<FilialVirtualResponse_v1_Bairro> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Bairro.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Bairro> getBairrosResult = getBairros();
        System.out.println(getBairrosResult);
    }
}
