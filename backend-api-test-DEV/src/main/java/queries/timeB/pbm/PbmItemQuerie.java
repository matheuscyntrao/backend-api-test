package queries.timeB.pbm;

import enums.time_b.pbm.PbmEnum;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.BaseQueries;

import java.util.List;

public class PbmItemQuerie extends BaseQueries {
    public static String getPbmItem(PbmEnum pbmEnum) {
        String SQL = String.format("SELECT DISTINCT CODIGO_DO_ITEM\n" +
                        "         FROM MVIEW_PHW_PBM_PROGRAMAS_ITENS  m\n" +
                        "         WHERE 1 = 1\n" +
                        "         AND codigo_admin_convenios = %d\n" +
                        "         AND SEQUENCIA_DO_PROGRAMA = %d\n" +
                        "        AND rownum = 1", pbmEnum.getCodigoAdminConvenios(),
                pbmEnum.getSequenciaDoPrograma());
        return getTemplate().queryForObject(SQL, String.class);
    }

}
