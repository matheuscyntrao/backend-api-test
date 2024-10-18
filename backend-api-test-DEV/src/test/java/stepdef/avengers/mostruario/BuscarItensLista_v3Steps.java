package stepdef.avengers.mostruario;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.request.ItensListaRequest_v3;
import model.avengers.mostruario.request.ItensListaRequest_v3_ConsultaRegrasFiscais;
import model.avengers.mostruario.request.ItensListaRequest_v3_Convenio;
import model.avengers.mostruario.request.ItensListaRequest_v3_Item;
import model.avengers.mostruario.response.ItensListaResponse_v3;
import service.avengers.mostruario.Mostruariov3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class BuscarItensLista_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - PostLista:$")
    public void possuo_dados_para_Mostruario_v3_PostLista(DataTable arg1) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_LISTA), CucumberUtils.getObjectBody(arg1, ItensListaRequest_v3.class));
    }

    @Dado("^possuo dados para Mostruario - v3 - PostLista convenios:$")
    public void possuo_dados_para_Mostruario_v3_PostLista_convenios(DataTable arg1) throws Throwable {
        ItensListaRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().getObjectBody(ItensListaRequest_v3.class);
        input.setConvenios(CucumberUtils.getObjectBody(arg1, ItensListaRequest_v3_Convenio[].class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().setBody(input);
    }

    @Dado("^possuo dados para Mostruario - v3 - PostLista itens:$")
    public void possuo_dados_para_Mostruario_v3_PostLista_itens(DataTable arg1) throws Throwable {
        ItensListaRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().getObjectBody(ItensListaRequest_v3.class);
        input.setItens(CucumberUtils.getObjectBody(arg1, ItensListaRequest_v3_Item[].class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().setBody(input);
    }

    @Dado("^possuo dados para Mostruario - v3 - PostLista consultaRegrasFiscais:$")
    public void possuo_dados_para_Mostruario_v3_PostLista_consultaRegrasFiscais(DataTable arg1) throws Throwable {
        ItensListaRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().getObjectBody(ItensListaRequest_v3.class);
        input.setConsultaRegrasFiscais(CucumberUtils.getObjectBody(arg1, ItensListaRequest_v3_ConsultaRegrasFiscais.class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceSpecs().setBody(input);
    }

    @Quando("^executo Mostruario - v3 - PostLista$")
    public void executo_Mostruario_v3_PostLista() throws Throwable {
        Mostruariov3.postLista.run();
    }

    @Entao("^sistema processa Mostruario - v3 - PostLista:$")
    public void sistema_processa_Mostruario_v3_PostLista(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_LISTA)).getServiceResponse()
                , ItensListaResponse_v3.class
        );

    }
}
