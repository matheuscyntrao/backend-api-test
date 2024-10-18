package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.request.deposit.PostDepositBillV1Request;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import model.tioPatinhas.bankAccount.response.deposit.PostDepositBillV1Response;
import service.bankAccount.DepositControllerV1;
import service.bankAccount.LoginAuthServerV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class PostDepositBillSteps {
    @Dado("possuo dados para BankAccountService - v1 - Token")
    public void possuoDadosParaBankAccountServiceV1GerarToken() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @Quando("executo BankAccountService - v1 - PostDepositBill:")
    public void executoBankAccountServiceV1PostDepositBill(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(DepositControllerV1.POST_DEPOSIT_BILL), CucumberUtils.getObjectBody(dataTable, PostDepositBillV1Request.class));
        DepositControllerV1.postDepositBill.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - DepositStatus:")
    public void sistemaProcessaBankAccountServiceV1DepositStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(DepositControllerV1.POST_DEPOSIT_BILL)).getServiceResponse()
                , PostDepositBillV1Response.class
        );
    }
}
