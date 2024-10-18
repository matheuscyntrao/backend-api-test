package stepdef.avengers.mostruario;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.request.ItensDetalheRequest_v3;
import model.avengers.mostruario.request.ItensDetalheRequest_v3_ConsultaRegrasFiscais;
import model.avengers.mostruario.request.ItensDetalheRequest_v3_Convenio;
import model.avengers.mostruario.request.ItensDetalheRequest_v3_Item;
import model.avengers.mostruario.response.ItensDetalheResponseV3;
import org.testng.Assert;
import service.avengers.mostruario.Mostruariov3;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.*;

import java.util.Arrays;
import java.util.Map;

public class BuscarItensDetalhe_v3Steps {
    @Dado("^possuo dados para Mostruario - v3 - PostItensDetalhe:$")
    public void possuo_dados_para_Mostruario_v3_PostItensDetalhe(DataTable arg1) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_DETALHE), CucumberUtils.getObjectBody(arg1, ItensDetalheRequest_v3.class));
    }

    @Dado("^possuo dados para Mostruario - v3 - PostItensDetalhe itens:$")
    public void possuo_dados_para_Mostruario_v3_PostItensDetalhe_itens(DataTable arg1) throws Throwable {
        ItensDetalheRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().getObjectBody(ItensDetalheRequest_v3.class);
        input.setItens(Arrays.asList(CucumberUtils.getObjectBody(arg1, ItensDetalheRequest_v3_Item[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().setBody(input);
    }

    @Dado("possuo dados para Mostruario - v3 - PostItensDetalhe convenio:")
    public void possuo_dados_para_mostruario_v3_post_itens_detalhe_convenio(DataTable dataTable) throws JsonProcessingException {
        ItensDetalheRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().getObjectBody(ItensDetalheRequest_v3.class);
        input.setConvenios(Arrays.asList(CucumberUtils.getObjectBody(dataTable, ItensDetalheRequest_v3_Convenio[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().setBody(input);
    }

    @Dado("^possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:$")
    public void possuo_dados_para_Mostruario_v3_PostItensDetalhe_consultaRegrasFiscais(DataTable arg1) throws Throwable {
        ItensDetalheRequest_v3 input = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().getObjectBody(ItensDetalheRequest_v3.class);
        input.setConsultaRegrasFiscais(CucumberUtils.getObjectBody(arg1, ItensDetalheRequest_v3_ConsultaRegrasFiscais.class));
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().setBody(input);
    }

    @Dado("^possuo dados para Mostruario - v3 - PostItensDetalhe param:$")
    public void possuo_dados_para_Mostruario_v3_PostItensDetalhe_param(Map<String, String> arg1) throws Throwable {
        Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceSpecs().param.putAll(arg1);
    }

    @Quando("^executo Mostruario - v3 - PostItensDetalhe$")
    public void executo_Mostruario_v3_PostItensDetalhe() throws Throwable {
        Mostruariov3.postDetalhe.run();
    }

    @Entao("^sistema processa Mostruario - v3 - PostItensDetalhe:$")
    public void sistema_processa_Mostruario_v3_PostItensDetalhe(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse()
                , ItensDetalheResponseV3.class
        );
    }

    @Entao("^valido Mostruario - v3 - PostItensDetalhe campo \"([^\"]*)\"$")
    public void valido_Mostruario_v3_PostItensDetalhe_campo(String campo) throws Throwable {
        if (!campo.isEmpty()) {
            JsonNode actualObj = null;
            ObjectMapper mapper = new ObjectMapper();
            actualObj = mapper.readTree(Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getBody());
            Assert.assertFalse(actualObj.findValue(campo).isNull());
        }
    }


    @Dado("efetuo Mostruario - v3 - PostItensDetalhe {int} {int} {int}")
    public void efetuo_mostruario_v3_post_itens_detalhe(Integer filial, Integer produto, Integer perfil) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_DETALHE), new ItensDetalheRequest_v3().createDetalhe(filial, produto, perfil));
        executo_Mostruario_v3_PostItensDetalhe();
    }
}
