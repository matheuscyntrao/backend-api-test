package stepdef.domino.convenio;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.convenio.response.ConvenioResponse_v2;
import service.domino.convenio.Conveniov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarConvenio_v2Steps {
    @Dado("^possuo dados para Convenio - v2 - GetConvenio param:$")
    public void possuo_dados_para_Convenio_v2_GetConvenio_param(Map<String, String> arg1) throws Throwable {
        BuilderRequest.param.accept(Util.rota.apply(Conveniov2.GET_CONVENIOS), arg1);
    }

    @Quando("^executo Convenio - v2 - GetConvenio$")
    public void executo_Convenio_v2_GetConvenio() throws Throwable {
        Conveniov2.getConvenio.run();
    }

    @Entao("^sistema processa Convenio - v2 - GetConvenio:$")
    public void sistema_processa_Convenio_v2_GetConvenio(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Conveniov2.GET_CONVENIOS)).getServiceResponse()
                , ConvenioResponse_v2[].class
        );
    }
}
