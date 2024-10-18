package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.request.PostCreateAccountV1Request;
import model.tioPatinhas.bankAccount.response.PostCreateAccountV1Response;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.AccountControllerV1;
import service.bankAccount.LoginAuthServerV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCreateAccountSteps {

    @Dado("possuo dados para BankAccountService - v1 - BuscaCPFBankAccount:")
    public void possuoDadosParaBankAccountServiceV1BuscaCPFBankAccount(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(AccountControllerV1.POST_CREATE_ACCOUNT), CucumberUtils.getObjectBody(dataTable, PostCreateAccountV1Request.class));
        String cpf = dataTable.asLists().get(1).get(0);
        Cache.valores.put(Util.rota.apply("CPF"), cpf);
    }


    @Quando("executo BankAccountService - v1 - PostCreateAccount {int}")
    public void executoBankAccountServiceV1PostCreateAccount(Integer qtdExecucao) {
        for (int i = 0; i < qtdExecucao; i++) {
            AccountControllerV1.postCreateAccount.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
        }
    }

    @Entao("sistema processa BankAccountService - v1 - CreateStatus:")
    public void sistemaProcessaBankAccountServiceV1CreateStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(AccountControllerV1.POST_CREATE_ACCOUNT)).getServiceResponse()
                , PostCreateAccountV1Response.class
        );
    }

    @After("@deleteAccount")
    public void delete() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(AccountControllerV1.POST_CREATE_ACCOUNT)).getServiceResponse().getStatusCode() == 409, () -> {
            deleteAccountByCpf();
        });
    }

    private void deleteAccountByCpf() {
        String cpf = Cache.valores.get(Util.rota.apply("CPF"));
        BuilderRequest.path.accept(Util.rota.apply(AccountControllerV1.DELETE_ACCOUNT_BY_CPF),Map.of("cpf",cpf));
        AccountControllerV1.deleteAccountByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @E("possuo dados para BankAccountService - v1 - GeraToken")
    public void possuoDadosParaBankAccountServiceV1GeraToken() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @E("possuo dados para BankAccountService - v1 - deleteAccountByCpf")
    public void possuoDadosParaBankAccountServiceV1DeleteAccountByCpf() {
        deleteAccountByCpf();
    }
}
