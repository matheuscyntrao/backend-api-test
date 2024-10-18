package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.request.PackIdentificadorRequest_v3;
import model.avengers.mostruario.request.PackIdentificadorRequest_v3_Convenio;
import model.avengers.mostruario.request.PackIdentificadorRequest_v3_Item;
import model.avengers.mostruario.response.PackIdentificadorResponse_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class BuscarPackIdentificador_v3Steps {
    @Dado("possuo dados para Mostruario - v3 - PostPacksIdentificador:")
    public void possuo_dados_para_Mostruario_v3_PostPacksIdentificador(DataTable dataTable) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR), CucumberUtils.getObjectBody(dataTable, PackIdentificadorRequest_v3.class));
    }

    @Dado("possuo dados para Mostruario - v3 - PostPacksIdentificador itens:")
    public void possuo_dados_para_Mostruario_v3_PostPacksIdentificador_itens(DataTable dados) throws Throwable {
        PackIdentificadorRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR)).getServiceSpecs().getObjectBody(PackIdentificadorRequest_v3.class);
        input.setItens(CucumberUtils.getObjectBody(dados, PackIdentificadorRequest_v3_Item[].class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR)).getServiceSpecs().setBody(input);
    }

    @Dado("^possuo dados para Mostruario - v3 - PostPacksIdentificador Convenios:$")
    public void possuo_dados_para_Mostruario_v3_PostPacksIdentificador_Convenios(DataTable arg1) throws Throwable {
        PackIdentificadorRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR)).getServiceSpecs().getObjectBody(PackIdentificadorRequest_v3.class);
        input.setConvenios(CucumberUtils.getObjectBody(arg1, PackIdentificadorRequest_v3_Convenio[].class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Mostruario - v3 - PostPacksIdentificador")
    public void executo_Mostruario_v3_PostPacksIdentificador() {
        Mostruariov3.postIdentificador.run();
    }

    @Entao("sistema processa Mostruario - v3 - PostPacksIdentificador:")
    public void sistema_processa_Mostruario_v3_PostPacksIdentificador(DataTable arg1) throws Exception {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_IDENTIFICADOR)).getServiceResponse()
                , PackIdentificadorResponse_v3[].class
        );
    }

}
