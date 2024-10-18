package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.response.GetBalanceByCpfV1Response;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.AccountControllerV1;
import service.bankAccount.BalanceControllerV1;
import service.bankAccount.LoginAuthServerV1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

public class GetBalanceByCpfSteps {
    @Dado("possuo dados para BankAccountService - v1 - GetCPFBalance:")
    public void possuoDadosParaBankAccountServiceV1GetCPFBalance(Map<String, String> dataTable) throws JsonProcessingException {
        BuilderRequest.path.accept(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF), dataTable);
    }

    @E("possuo dados para BankAccountService - v1 - TokenBalance")
    public void possuoDadosParaBankAccountServiceV1TokenBalance() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @Quando("executo BankAccountService - v1 - GetBalance")
    public void executoBankAccountServiceV1GetBalance(){
        BalanceControllerV1.getBalanceByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - GetBalanceStatus:")
    public void sistemaProcessaBankAccountServiceV1GetBalanceStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF)).getServiceResponse()
                , GetBalanceByCpfV1Response.class
        );
    }
}
