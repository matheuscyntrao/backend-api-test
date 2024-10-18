package stepdef.timeB.skyhub;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.timeB.skyhub.response.Product;
import org.testng.SkipException;
import queries.timeB.marketplaceSeller.TableQuerie;
import service.timeB.skyhub.Skyhub;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetSkyhubProdutosCode_Steps {
    @Dado("possuo dados para Skuhub - v1 - GetProdutosCode path:")
    public void possuo_dados_para_skuhub_v1_get_produtos_code_path(Map<String,String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE), dataTable);
    }

    @Quando("executo Skyhub - v1 - GetProdutosCode")
    public void executo_skyhub_v1_get_produtos_code() {
        Skyhub.getProdutosCode.run();
    }

    @Entao("sistema processa Skyhub - v1 - GetProdutosCode:")
    public void sistema_processa_skyhub_v1_get_produtos_code(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE)).getServiceResponse()
                , Product.class
        );
    }

    @Before("@validaTabelaProdutosBkp")
    public void skipp() {
        assumingThat(!TableQuerie.getTableBkpExist(), () -> {
            throw new SkipException("Não tenho condiçoes de testar, verificar script pós refresh  \n" +
                    "create table proecm.ECM_ITENS_MARKETPLACE_BKP as ( select * from proecm.ECM_ITENS_MARKETPLACE)");
        });
    }
}
