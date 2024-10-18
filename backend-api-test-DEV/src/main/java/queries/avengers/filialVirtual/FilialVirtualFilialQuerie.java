package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Canal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Filial;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualFilialQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Filial> getFiliais() {
        String SQL = "Select Par.Codigo_Da_Filial codigoFilial \n" +
                "      ,Par.Nome_Amigavel nomeAmigavel \n" +
                "  From Parametros_Das_Filiais Par\n" +
                " Where 1 = 1\n" +
                " Order By 1 \n";
        List<FilialVirtualResponse_v1_Filial> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Filial.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Filial> getFiliaisResult = getFiliais();
        System.out.println(getFiliaisResult);
    }
}
