package queries.brocacao.omniDashboardBff;

import com.epam.reportportal.service.ReportPortal;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialQuerie extends BaseQueries {
    public static List<String> getFiliais() {
        String SQL = "Select Par.Codigo_Da_Filial \n" +
                " From Parametros_Das_Filiais Par\n" +
                " Where 1 = 1\n" +
                " Order By 1 ";
        List<String> result = getTemplate().queryForList(SQL,String.class);
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<String> getFiliaisResult = getFiliais();
        System.out.println(getFiliaisResult);
    }
}
