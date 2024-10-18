package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FiliaisQuerie extends BaseQueries {
    public static List<String> getFiliais() {
        String SQL = "Select Par.Codigo_Da_Filial\n" +
                "  From Parametros_Das_Filiais Par\n" +
                " Where 1 = 1\n" +
                "   And Par.Data_Da_Ultima_Abertura >= Trunc(Sysdate - 10)\n" +
                " Order By 1 \n";
        List<String> result = getTemplate().queryForList(SQL, String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> querieResult = getFiliais();
        System.out.println(querieResult);
    }
}
