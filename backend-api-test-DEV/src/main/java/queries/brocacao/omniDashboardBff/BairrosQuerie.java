package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import model.brocacao.omniDashboardBff.Coverage.CoverageValues;
import model.coupon.response.PostCouponData_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class BairrosQuerie extends BaseQueries {
    public static List<CoverageValues> getBairros() {
        String SQL = "SELECT \n" +
                "         DISTINCT Bai.Codigo_Da_Localidade codigoLocalidade, \n" +
                "         Bai.Nome_Do_Bairro nomeBairro \n" +
                "     FROM \n" +
                "         Entidades_Comerciais Enc , \n" +
                "         Enderecos_De_Entidade_Com Eec , \n" +
                "         Enderecos_De_Ent_Com_Por_Tipo Etp , \n" +
                "         Localidades Loc , \n" +
                "         Logradouros Lgr , \n" +
                "         Bairros Bai , \n" +
                "         Filiais_Da_Area ARE , \n" +
                "         Areas_De_Supervisao Asu \n" +
                "     WHERE \n" +
                "         Enc.Codigo_Da_Entidade_Comercial = Eec.Codigo_Da_Entidade_Comercial \n" +
                "         AND Eec.Codigo_Da_Entidade_Comercial = Etp.Codigo_Da_Entidade_Comercial(+) \n" +
                "         AND Eec.Sequencia_Do_End_Da_Ent_Com = Etp.Sequencia_Do_End_Da_Ent_Com(+) \n" +
                "         AND Eec.Codigo_Da_Localidade = Loc.Codigo_Da_Localidade \n" +
                "         AND Eec.Codigo_Da_Localidade = Lgr.Codigo_Da_Localidade \n" +
                "         AND Eec.Codigo_Do_Logradouro = Lgr.Codigo_Do_Logradouro \n" +
                "         AND Lgr.Codigo_Da_Localidade_Bairro = Bai.Codigo_Da_Localidade \n" +
                "         AND Lgr.Codigo_Do_Bairro = Bai.Codigo_Do_Bairro \n" +
                "         AND Enc.Codigo_Da_Entidade_Comercial = Are.Codigo_Da_Filial \n" +
                "         AND Are.Codigo_Da_Area_De_Supervisao = Asu.Codigo_Da_Area_De_Supervisao \n" +
                "         AND Etp.Codigo_Do_Tipo_De_Endereco = 4 \n" +
                "         AND Enc.Codigo_Do_Distribuidor_Dimed IS NOT NULL \n" +
                "     ORDER BY \n" +
                "         1 \n";
        List<CoverageValues> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(CoverageValues.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<CoverageValues> getCanaisResult = getBairros();
        System.out.println(getCanaisResult);
    }
}
