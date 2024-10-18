package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import model.brocacao.omniDashboardBff.Coverage.CoverageValues;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class SupervisaoQuerie extends BaseQueries {
    public static List<String> getSupervisao() {
        String SQL = "Select Are.Desc_Da_Area_De_Supervisao\n" +
                "  From Areas_De_Supervisao Are\n" +
                " Where 1 = 1\n" +
                "   And Exists (Select 1\n" +
                "          From Filiais_Da_Area        Fil\n" +
                "              ,Parametros_Das_Filiais Par\n" +
                "         Where Par.Codigo_Da_Filial = Fil.Codigo_Da_Filial\n" +
                "           And 1 = 1\n" +
                "           And Fil.Codigo_Da_Area_De_Supervisao = Are.Codigo_Da_Area_De_Supervisao)\n" +
                " Order By 1\n";
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> getSupervisao = getSupervisao();
        System.out.println(getSupervisao);
    }
}
