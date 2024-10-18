package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.request.PackIdentificadorRequest_v3_Item;
import model.avengers.mostruario.request.PackIdentificadorRequest_v4;
import model.avengers.mostruario.response.PackIdentificadorResponse_v4;
import service.avengers.mostruario.Mostruariov4;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;


public class BuscarPackIdentificador_v4Steps {
    @Dado("^possuo dados para Mostruario - v4 - PostPacksIdentificador:$")
    public void possuo_dados_para_Mostruario_v4_PostPacksIdentificador(DataTable arg1) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov4.POST_IDENTIFICADOR), CucumberUtils.getObjectBody(arg1, PackIdentificadorRequest_v4.class));
    }

    @Dado("^possuo dados para Mostruario - v4 - PostPacksIdentificador itens:$")
    public void possuo_dados_para_Mostruario_v4_PostPacksIdentificador_itens(DataTable arg1) throws Throwable {
        PackIdentificadorRequest_v4 input = Cache.chamadas.get(Util.rota.apply(Mostruariov4.POST_IDENTIFICADOR)).getServiceSpecs().getObjectBody(PackIdentificadorRequest_v4.class);
        input.setItens(CucumberUtils.getObjectBody(arg1, PackIdentificadorRequest_v3_Item[].class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov4.POST_IDENTIFICADOR)).getServiceSpecs().setBody(input);
    }

    @Quando("^executo Mostruario - v4 - PostPacksIdentificador$")
    public void executo_Mostruario_v4_PostPacksIdentificador() throws Throwable {
        Mostruariov4.postIdentificador.run();
    }

    @Entao("^sistema processa Mostruario - v4 - PostPacksIdentificador:$")
    public void sistema_processa_Mostruario_v4_PostPacksIdentificador(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov4.POST_IDENTIFICADOR)).getServiceResponse()
                , PackIdentificadorResponse_v4[].class
        );
    }
}
