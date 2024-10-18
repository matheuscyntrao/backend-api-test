package queries.digital.authentication;

import com.epam.reportportal.service.ReportPortal;
import entity.digital.authentication.UsuarioLoginEntity;
import model.avengers.filialVirtual.response.FilialVirtualResponse_v1_Uf;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class UsuariosLoginQuerie extends BaseQueries {
    public static List<UsuarioLoginEntity> getUsuarios(String usuario) {
        String SQL = String.format("SELECT \n" +
                "\tECM.CODIGO_DA_ENTIDADE_COMERCIAL as codigo\n" +
                "\t,ECM.USUARIO_INTERNET as usuario\n" +
                "\t,ECM.SENHA_INTERNET as senha\n" +
                "\t,ECM.POSSUI_BLOQUEIO as isBloqueado\n" +
                "\t,ECM.USUARIO_LIBERADO as isLiberado\n" +
                "FROM ecm_clientes ecm\n" +
                "WHERE usuario_internet ='%s'", usuario);
        List<UsuarioLoginEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(UsuarioLoginEntity.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<UsuarioLoginEntity> querieResult = getUsuarios("neusinha_santos@yahoo.com.br");
        System.out.println(querieResult);
    }
}
