package stepdef.domino.filial;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.filial.request.PostFiliaisEstoqueRequestV1;
import model.domino.filial.response.PostFiliaisEstoqueResponseV1;
import service.domino.filial.Filialv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;
import utils.service.ServiceSpecs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PostFiliaisEstoqueV1Steps {

    private static String ROTA = Filialv1.POST_FILIAIS_ESTOQUE;

    @Dado("possuo dados para Filial - v1 - PostFiliaisEstoque:")
    public void possuo_dados_para_filial_v1_post_filiais_estoque(Map<String, String> dataTable) throws JsonProcessingException {
        PostFiliaisEstoqueRequestV1 body = new PostFiliaisEstoqueRequestV1();
        List<String> filiais = Arrays.asList(dataTable.get("filiais").split(","));
        List<String> itens = Arrays.asList(dataTable.get("itens").split(","));
        body.setFiliais(filiais.stream().map(Integer::parseInt).collect(Collectors.toList()));
        body.setItens(itens.stream().map(Integer::parseInt).collect(Collectors.toList()));
        BuilderRequest.body.accept(Util.rota.apply(ROTA), body);
    }

    @Quando("executo Filial - v1 - PostFiliaisEstoque")
    public void executo_filial_v1_post_filiais_estoque() {
        Filialv1.postFiliaisEstoque.run();
    }

    @Entao("sistema processa Filial - v1 - PostFiliaisEstoque:")
    public void sistema_processa_filial_v1_post_filiais_estoque(io.cucumber.datatable.DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostFiliaisEstoqueResponseV1[].class
        );
    }
}
