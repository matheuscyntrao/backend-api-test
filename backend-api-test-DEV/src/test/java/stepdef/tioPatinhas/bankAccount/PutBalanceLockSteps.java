package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.request.PostCreateAccountV1Request;
import model.tioPatinhas.bankAccount.request.PutBalanceLockV1Request;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.AccountControllerV1;
import service.bankAccount.BalanceControllerV1;
import service.bankAccount.LoginAuthServerV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class PutBalanceLockSteps {
    @Dado("possuo dados para BankAccountService - v1 - CPFBalanceLock:")
    public void possuoDadosParaBankAccountServiceV1CPFBalanceLock(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(BalanceControllerV1.PUT_BALANCE_LOCK), CucumberUtils.getObjectBody(dataTable, PutBalanceLockV1Request.class));
        String cpf = dataTable.asLists().get(1).get(0);
        Cache.valores.put(Util.rota.apply("CPF"), cpf);
    }

    @E("possuo dados para BankAccountService - v1 - TokenBalanceLock")
    public void possuoDadosParaBankAccountServiceV1TokenBalanceLock() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @E("possuo dados para BankAccountService - v1 - deleteAccountByCpfToBalance {int}")
    public void possuoDadosParaBankAccountServiceV1DeleteAccountByCpfToBalance(Integer qtdExecucao) {
        if(qtdExecucao>0) {
            deleteAccountByCpf();
        }
    }

    @E("executo BankAccountService - v1 - PostCreateAccountBalance: {int}")
    public void executoBankAccountServiceV1PostCreateAccount(Integer qtdExecucao,DataTable dataTable) throws JsonProcessingException {
        if(qtdExecucao>0) {
            BuilderRequest.body.accept(Util.rota.apply(AccountControllerV1.POST_CREATE_ACCOUNT), CucumberUtils.getObjectBody(dataTable, PostCreateAccountV1Request.class));
            for (int i = 0; i < qtdExecucao; i++) {
                AccountControllerV1.postCreateAccount.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
            }
        }
    }

    @Quando("executo BankAccountService - v1 - PutBalanceLock")
    public void executoBankAccountServiceV1PutBalanceLock() {
        BalanceControllerV1.putBalanceLock.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - UpdateStatusLock:")
    public void sistemaProcessaBankAccountServiceV1UpdateStatusLock(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.PUT_BALANCE_LOCK)).getServiceResponse()
                , PutBalanceLockV1Request.class
        );
    }

    private void deleteAccountByCpf() {
        String cpf = Cache.valores.get(Util.rota.apply("CPF"));
        BuilderRequest.path.accept(Util.rota.apply(AccountControllerV1.DELETE_ACCOUNT_BY_CPF), Map.of("cpf",cpf));
        AccountControllerV1.deleteAccountByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }
}
