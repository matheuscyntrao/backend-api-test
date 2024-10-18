package queries.timeB.pbm;

import entity.timeb.pbmGateway.PbmDataSitePhoneEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;
import java.util.Map;

public class PbmDadosSitePhoneAdminQuery extends BaseQueries {
    public static void insertAdmin(Map<String, String> datatable) {
        String SQL = String.format("INSERT INTO Pro_Programas_Administradoras (CODIGO_ADMIN_CONVENIOS, SEQUENCIA_DO_PROGRAMA,NOME_DO_PROGRAMA, \n" +
                "TIPO_DE_PROGRAMA, DATA_INICIO_PROGRAMA, MEIO_DE_CONTATO_PDV, MEIO_DE_CONTATO, TELEFONE_CONTATO) \n" +
                "VALUES (50000, 102,'TESTE PROGRAMA', 'P', sysdate, %s, null, null)", datatable.get("meioDeContatoPdv"));
        getTemplate().execute(SQL);
    }

    public static void deleteInsertedAdmin() {
        String SQL = String.format("delete from Pro_Programas_Administradoras WHERE CODIGO_ADMIN_CONVENIOS = 50000");
        getTemplate().execute(SQL);
    }

    public static PbmDataSitePhoneEntity getInsertedAdmin() {
        String SQL = "select MEIO_DE_CONTATO_PDV as meioDeContatoPDV, MEIO_DE_CONTATO as meioDeContato, \n" +
                "TELEFONE_CONTATO as telefoneContato, CODIGO_ADMIN_CONVENIOS as codigoAdminConvenios from Pro_Programas_Administradoras WHERE CODIGO_ADMIN_CONVENIOS = 50000";
        List<PbmDataSitePhoneEntity> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PbmDataSitePhoneEntity.class));
        return result.get(0);
    }
}
