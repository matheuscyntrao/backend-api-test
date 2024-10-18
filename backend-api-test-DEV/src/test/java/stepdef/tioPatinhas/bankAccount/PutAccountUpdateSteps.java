package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.PostAndPutCouponCoverage_v1Request;
import model.tioPatinhas.bankAccount.request.PostCreateAccountV1Request;
import model.tioPatinhas.bankAccount.request.PutAccountUpdateV1Request;
import model.tioPatinhas.bankAccount.response.GetAndPutAccountByCpfV1Response;
import model.tioPatinhas.bankAccount.response.PostCreateAccountV1Response;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.AccountControllerV1;
import service.bankAccount.LoginAuthServerV1;
import service.coupon.CouponCoverage_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

public class PutAccountUpdateSteps {
    @Dado("possuo dados para BankAccountService - v1 - CPFBankAccount:")
    public void possuoDadosParaBankAccountServiceV1CPFBankAccount(DataTable dataTable) throws JsonProcessingException {
        String cpf = dataTable.asLists().get(1).get(0);
        Cache.valores.put(Util.rota.apply("CPF"), cpf);
    }

    @E("possuo dados para BankAccountService - v1 - GerarToken")
    public void possuoDadosParaBankAccountServiceV1GerarToken() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @Quando("executo BankAccountService - v1 - UpdateAccount:")
    public void executoBankAccountServiceV1UpdateAccount(DataTable dataTable) throws JsonProcessingException {
        String cpf = Cache.valores.get(Util.rota.apply("CPF"));
        BuilderRequest.path.accept(Util.rota.apply(AccountControllerV1.PUT_ACCOUNT_UPDATE),Map.of("cpf",cpf));
        BuilderRequest.body.accept(Util.rota.apply(AccountControllerV1.PUT_ACCOUNT_UPDATE), CucumberUtils.getObjectBody(dataTable, PutAccountUpdateV1Request.class));
        AccountControllerV1.putAccountUpdate.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - UpdateStatus:")
    public void sistemaProcessaBankAccountServiceV1UpdateStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(AccountControllerV1.PUT_ACCOUNT_UPDATE)).getServiceResponse()
                , GetAndPutAccountByCpfV1Response.class
        );
    }
}
