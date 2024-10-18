package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.request.FilialVirtualNotaRequest_v1;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class FilialVirtualNota_v1Steps {
    @Dado("^possuo dados para FilialVirtual - v1 - PostNota:$")
    public void possuo_dados_para_FilialVirtual_v1_PostNota(DataTable arg1) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(FilialVirtualv1.POST_NOTA)
                , CucumberUtils.getObjectBody(arg1, FilialVirtualNotaRequest_v1.class));
    }

    @Quando("^executo FilialVirtual - v1 - PostNota$")
    public void executo_FilialVirtual_v1_PostNota() throws Throwable {
        FilialVirtualv1.postNota.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - PostNota:$")
    public void sistema_processa_FilialVirtual_v1_PostNota(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.POST_NOTA)).getServiceResponse()
                , String.class
        );
    }


}
