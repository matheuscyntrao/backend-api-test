package stepdef.tioPatinhas.matera;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.matera.response.GetMateraAccountV1Response;
import service.bankAccount.MateraAccountV1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetAccountSteps {
    static final String ROTA = MateraAccountV1.GET_MATERA_ACCOUNT_BY_ID;

    @Dado("possuo dados para Matera - v1 - GetAccount path:")
    public void possuo_dados_para_matera_v1_get_account(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo Matera - v1 - GetAccount")
    public void executo_matera_v1_get_account() {
        MateraAccountV1.getMateraAccountByID.run();
    }

    @Entao("sistema processa Matera - v1 - GetAccount:")
    public void sistema_processa_matera_v1_get_account(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetMateraAccountV1Response.class
        );
    }

    public void efetuoMateraGetAccount(String account){
        possuo_dados_para_matera_v1_get_account(Map.of("accountId", account));
        executo_matera_v1_get_account();
    }

    @Dado("efetuo Matera - v1 - GetAccount {string}")
    public void efetuo_matera_v1_get_account(String account) {
        efetuoMateraGetAccount(account);
    }
}
