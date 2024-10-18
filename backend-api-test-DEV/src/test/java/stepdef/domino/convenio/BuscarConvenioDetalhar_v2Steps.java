package stepdef.domino.convenio;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.convenio.request.ConvenioDetalharRequest_v2;
import model.domino.convenio.request.ConvenioDetalharRequest_v2_Matricula;
import model.domino.convenio.response.ConvenioDetalharResponse_v2;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;
import service.domino.convenio.Conveniov2;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;

public class BuscarConvenioDetalhar_v2Steps {
    private static String ROTA = Conveniov2.POST_CONVENIO_DETALHAR;
    @Dado("^possuo dados para Convenio - v2 - PostConvenioDetalhar:")
    public void possuo_dados_para_Convenio_v2_PostConvenioDetalhar(DataTable dataTable) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, ConvenioDetalharRequest_v2.class));
    }

    @Dado("^possuo dados para Convenio - v2 - PostConvenioDetalhar Matriculas:")
    public void possuo_dados_para_Convenio_v2_PostConvenioDetalhar_Matriculas(DataTable dataTable) throws Throwable {
        ConvenioDetalharRequest_v2 body = Cache.chamadas.get(Util.rota.apply(Conveniov2.POST_CONVENIO_DETALHAR)).getServiceSpecs().getObjectBody(ConvenioDetalharRequest_v2.class);
        body.setMatriculas(CucumberUtils.getObjectBody(dataTable, ConvenioDetalharRequest_v2_Matricula[].class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Dado("possuo dados para Convenio - v2 - PostConvenioDetalhar Cartoes {string}")
    public void possuo_dados_para_convenio_v2_post_convenio_detalhar_cartoes(String dataTable) throws JsonProcessingException {
        ConvenioDetalharRequest_v2 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(ConvenioDetalharRequest_v2.class);
        body.setCartoes(Arrays.asList(dataTable.split(",").clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }
    @Quando("^executo Convenio - v2 - PostConvenioDetalhar")
    public void executo_Convenio_v2_PostConvenioDetalhar() throws Throwable {
        Conveniov2.postConvenioDetalhar.run();
    }

    @Entao("^sistema processa Convenio - v2 - PostConvenioDetalhar:")
    public void sistema_processa_Convenio_v2_PostConvenioDetalhar(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , ConvenioDetalharResponse_v2[].class
        );
    }
}
