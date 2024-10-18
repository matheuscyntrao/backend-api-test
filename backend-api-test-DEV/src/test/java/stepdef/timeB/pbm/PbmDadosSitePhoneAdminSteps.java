package stepdef.timeB.pbm;

import entity.timeb.pbmGateway.PbmDataSitePhoneEntity;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import queries.timeB.pbm.PbmDadosSitePhoneAdminQuery;

import java.util.Map;

public class PbmDadosSitePhoneAdminSteps {
    @Dado("possuo dados para Pbm - Dados Site Phone Admin")
    public void possuo_dados_para_pbm_dados_site_phone_admin(Map<String, String> dataTable) {
        PbmDadosSitePhoneAdminQuery.insertAdmin(dataTable);
    }

    @Quando("executo Pbm - Dados Site Phone Admin")
    public void executo_pbm_dados_site_phone_admin() {
        //TODO: Adicionar codigo para rodar o JOB que vai atualizar as colunas conforme esperado
    }

    @Entao("valido Pbm - Dados Site Phone Admin")
    public void valido_pbm_dados_site_phone_admin() {
        PbmDataSitePhoneEntity query = new PbmDataSitePhoneEntity();
        query = PbmDadosSitePhoneAdminQuery.getInsertedAdmin();
        System.out.println("");
        System.out.println(query.getCodigoAdminConvenios());
        System.out.println(query.getMeioDeContatoPDV());
        System.out.println(query.getMeioDeContato());
        System.out.println(query.getTelefoneContato());
        System.out.println("");
        //TODO: Inserir validações necessárias da US
        PbmDadosSitePhoneAdminQuery.deleteInsertedAdmin();
    }
}
