package queries.avengers.filialVirtual;

import com.epam.reportportal.service.ReportPortal;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Uf;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class FilialVirtualUFQuerie extends BaseQueries {
    public static List<FilialVirtualResponse_v1_Uf> getUfs() {
        String SQL = "Select Ufs.Sigla_Do_Pais pais\n" +
                "      ,Ufs.Sigla_Da_Uf uf\n" +
                "      ,Ufs.Nome_Da_Uf nomeUf\n" +
                "      ,Ufs.Codigo_Da_Uf_Ibge codigoUfIbge\n" +
                "  From Ufs\n" +
                " Where Ufs.Sigla_Do_Pais = 'BR'\n" +
                "   And Exists (Select 1\n" +
                "          From Parametros_Das_Filiais Par\n" +
                "              ,Entidades_Comerciais   Ent\n" +
                "         Where Par.Codigo_Da_Filial = Ent.Codigo_Da_Entidade_Comercial\n" +
                "           And 1 = 1 \n" +
                "           And Ent.Sigla_Da_Uf = Ufs.Sigla_Da_Uf)\n" +
                " Order By 1\n";
        List<FilialVirtualResponse_v1_Uf> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(FilialVirtualResponse_v1_Uf.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<FilialVirtualResponse_v1_Uf> getUf = getUfs();
        System.out.println(getUf);
    }
}
