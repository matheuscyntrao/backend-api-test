package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import model.brocacao.omniDashboardBff.Coverage.CoverageValues;
import model.coupon.response.PostCouponData_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;


public class UFQuerie extends BaseQueries {
    public static List<String> getUfs() {
        String SQL = "Select Ufs.Sigla_Da_Uf \n" +
                "  From Ufs\n" +
                " Where Ufs.Sigla_Do_Pais = 'BR'\n" +
                "   And Exists (Select 1\n" +
                "          From Parametros_Das_Filiais Par\n" +
                "              ,Entidades_Comerciais   Ent\n" +
                "         Where Par.Codigo_Da_Filial = Ent.Codigo_Da_Entidade_Comercial\n" +
                "           And Par.Data_Da_Ultima_Abertura >= Trunc(Sysdate - 10)\n" +
                "           And Ent.Sigla_Da_Uf = Ufs.Sigla_Da_Uf)\n" +
                " Order By Sigla_Da_Uf\n";
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        System.out.println(result);
        return  result;
    }

    public static void main(String[] args) {
        List<String> getUf = getUfs();
        System.out.println(getUf);
    }
}
