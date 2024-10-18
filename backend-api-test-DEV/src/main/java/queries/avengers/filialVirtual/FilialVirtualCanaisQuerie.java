package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Canal;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualCanaisQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Canal> getCanais() {
        String SQL = "Select Prf.Codigo_Do_Perfil codigo\n" +
                "       ,Prf.Descricao_Do_Perfil perfil\n" +
                "   From Phw_Perfis_De_Venda Prf\n" +
                " Where Prf.Codigo_Do_Perfil != 4\n" +
                " Order By Prf.Codigo_Do_Perfil\n";
        List<FilialVirtualResponse_v1_Canal> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Canal.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Canal> getCanaisResult = getCanais();
        System.out.println(getCanaisResult);
    }
}
