package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Supervisao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualSupervisaoQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Supervisao> getSupervisao() {
        String SQL = "Select Are.Codigo_Da_Area_De_Supervisao codigoAreaSupervisao\n" +
                "      ,Are.Desc_Da_Area_De_Supervisao descricaoAreaSupervisao\n" +
                "      ,Are.Codigo_Do_Supervisor codigoSupervisor\n" +
                "      ,Are.Codigo_Da_Area_geral codigoAreaGeral\n" +
                "      ,Are.Codigo_Regional codigoRegional\n" +
                " From Areas_De_Supervisao Are\n" +
                " Where 1 = 1\n" +
                "   And Exists (Select 1\n" +
                "          From Filiais_Da_Area        Fil\n" +
                "              ,Parametros_Das_Filiais Par\n" +
                "         Where Par.Codigo_Da_Filial = Fil.Codigo_Da_Filial\n" +
                "           And 1 = 1\n" +
                "           And Fil.Codigo_Da_Area_De_Supervisao = Are.Codigo_Da_Area_De_Supervisao)\n" +
                " Order By 1\n";
        List<FilialVirtualResponse_v1_Supervisao> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Supervisao.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Supervisao> getSupervisao = getSupervisao();
        System.out.println(getSupervisao);
    }
}
