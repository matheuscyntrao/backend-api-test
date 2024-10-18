package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.request.PutBalanceLockV1Request;
import model.tioPatinhas.bankAccount.request.PutBalanceUnlockV1Request;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.BalanceControllerV1;
import service.bankAccount.LoginAuthServerV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PutBalanceUnlockSteps {
    @Dado("possuo dados para BankAccountService - v1 - CPFBalanceUnlock:")
    public void possuoDadosParaBankAccountServiceVCPFBalanceUnlock(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(BalanceControllerV1.PUT_BALANCE_UNLOCK), CucumberUtils.getObjectBody(dataTable, PutBalanceUnlockV1Request.class));
    }

    @E("possuo dados para BankAccountService - v1 - TokenBalanceUnlock")
    public void possuoDadosParaBankAccountServiceVTokenBalanceUnlock() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @Quando("executo BankAccountService - v1 - PutBalanceUnlock")
    public void executoBankAccountServiceVPutBalanceUnlock() {
        BalanceControllerV1.putBalanceUnlock.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - UpdateStatusUnlock:")
    public void sistemaProcessaBankAccountServiceVUpdateStatusUnlock(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.PUT_BALANCE_UNLOCK)).getServiceResponse()
                , PutBalanceUnlockV1Request.class
        );
    }
}
