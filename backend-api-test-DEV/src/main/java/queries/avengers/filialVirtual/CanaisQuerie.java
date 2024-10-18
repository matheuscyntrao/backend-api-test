package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CanaisQuerie extends BaseQueries {
    public static List<String> getCanais() {
        String SQL = "Select Prf.Descricao_Do_Perfil\n" +
                "  From Phw_Perfis_De_Venda Prf\n" +
                " Where Prf.Codigo_Do_Perfil != 4\n" +
                " Order By Prf.Codigo_Do_Perfil\n";
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> querieResult = getCanais();
        System.out.println(querieResult);
    }
}
