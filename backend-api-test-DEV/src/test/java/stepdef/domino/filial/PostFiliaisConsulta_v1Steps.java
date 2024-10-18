package stepdef.domino.filial;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shippingService.request.PostDeliveriesRequest_v1;
import model.domino.filial.request.PostFiliaisConsultaRequest_v1;
import model.domino.filial.response.PostFiliaisConsultaResponse_v1;
import service.domino.filial.Filialv1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PostFiliaisConsulta_v1Steps {

    private static String ROTA = Filialv1.POST_FILIAIS_CONSULTA;

    @Dado("possuo dados para Filial - v1 - PostFiliaisConsulta:")
    public void possuo_dados_para_filial_v1_post_filiais_consulta(DataTable dataTable) throws JsonProcessingException {
        PostFiliaisConsultaRequest_v1 body = CucumberUtils.getObjectBody(dataTable,PostFiliaisConsultaRequest_v1.class);
        body.setData(LocalDate.now().plusDays(Long.parseLong(body.getData())).toString().concat("T00:00:00"));
        BuilderRequest.body.accept(Util.rota.apply(ROTA), body);
    }


    @Dado("possuo dados para Filial - v1 - PostFiliaisConsulta filiais {string}:")
    public void possuo_dados_para_filial_v1_post_filiais_consulta_filiais(String string) {
        PostFiliaisConsultaRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostFiliaisConsultaRequest_v1.class);
        List<Integer> filiais = Arrays.stream(Arrays.stream(string.split(",")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        body.setFiliais(filiais);
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo Filial - v1 - PostFiliaisConsulta")
    public void executo_filial_v1_post_filiais_consulta() {
        Filialv1.postFiliaisConsulta.run();
    }

    @Entao("sistema processa Filial - v1 - PostFiliaisConsulta:")
    public void sistema_processa_filial_v1_post_filiais_consulta(DataTable dataTable) throws Exception {
         ResponseValidator.validaResponse(dataTable
                         , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                         , PostFiliaisConsultaResponse_v1[].class
                 );
    }
}
