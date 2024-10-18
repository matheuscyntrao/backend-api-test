package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import mapper.tioPatinhas.bankAccount.BankAccountMapper;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import model.tioPatinhas.bankAccount.request.PostInternalTransferV1Request;
import model.tioPatinhas.bankAccount.response.GetAndPutAccountByCpfV1Response;
import model.tioPatinhas.bankAccount.response.GetBalanceByCpfV1Response;
import model.tioPatinhas.bankAccount.response.PostLoginAuthV1Response;
import service.bankAccount.*;
import service.crossover.cliente.Clientev2Pip;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;

public class PostInternalTransferSteps {
    private BigDecimal saldoReceiver;
    private BigDecimal saldoSender;

    @Dado("possuo dados para BankAccountService - v1 - BuscaCPFTransferBankAccount:")
    public void possuoDadosParaBankAccountServiceV1BuscaCPFTransferBankAccount(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(PaymentControllerV1.POST_INTERNAL_TRANSFER), CucumberUtils.getObjectBody(dataTable, PostInternalTransferV1Request.class));
        String receiverDocument = dataTable.asLists().get(1).get(0);
        Cache.valores.put(Util.rota.apply("RECEIVERDOCUMENT"), receiverDocument);
        String senderDocument = dataTable.asLists().get(1).get(1);
        Cache.valores.put(Util.rota.apply("SENDERDOCUMENT"), senderDocument);
    }

    @E("possuo dados para BankAccountService - v1 - GeraTokenTransfer")
    public void possuoDadosParaBankAccountServiceV1GeraTokenTransfer() {
        BuilderRequest.simple.accept(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH));
        LoginAuthServerV1.postLoginAuthorization.run();
        Cache.valores.put(Util.rota.apply("TOKEN"), "Bearer ".concat(Cache.chamadas.get(Util.rota.apply(LoginAuthServerV1.POST_LOGIN_AUTH))
                .getServiceResponse()
                .getObjectBody(PostLoginAuthV1Response.class).getAccessToken()));
    }

    @Quando("executo BankAccountService - v1 - PostInternalTransfer {int}")
    public void executoBankAccountServiceV1PostInternalTransfer(Integer saveBalance) {
        if(saveBalance>0){
            saldoReceiver = GetReceiverBalance();
            saldoSender = GetSenderBalance();
        }
        PaymentControllerV1.postInternalTransfer.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - TransferStatus:")
    public void sistemaProcessaBankAccountServiceV1TransferStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(PaymentControllerV1.POST_INTERNAL_TRANSFER)).getServiceResponse()
                , PostInternalTransferV1Request.class
        );
    }

    private BigDecimal GetReceiverBalance() {
        String receiverDocument = Cache.valores.get(Util.rota.apply("RECEIVERDOCUMENT"));
        BuilderRequest.path.accept(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF), Map.of("cpf", receiverDocument));
        BalanceControllerV1.getBalanceByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
        BigDecimal receiverBalance = Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF)).getServiceResponse()
                .getObjectBody(GetBalanceByCpfV1Response.class).getReal();
        return receiverBalance;
    }

    private BigDecimal GetSenderBalance() {
        String senderDocument = Cache.valores.get(Util.rota.apply("SENDERDOCUMENT"));
        BuilderRequest.path.accept(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF), Map.of("cpf", senderDocument));
        BalanceControllerV1.getBalanceByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
        BigDecimal senderBalance = Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF)).getServiceResponse()
                .getObjectBody(GetBalanceByCpfV1Response.class).getReal();
        return senderBalance;
    }

    @E("valido BankAccountService - v1 - ValidaTransfer")
    public void validoBankAccountServiceV1ValidaTransfer() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(BalanceControllerV1.GET_BALANCE_BY_CPF)).getServiceResponse().getStatusCode() == 204, () -> {

            BigDecimal saldoReceiverApos = GetReceiverBalance();
            BigDecimal saldoSenderApos = GetSenderBalance();

            assertAll(
                    () -> assertEquals(saldoReceiverApos, saldoReceiver.add(BigDecimal.valueOf(10)), "saldo Receiver"),
                    () -> assertEquals(saldoSenderApos, saldoSender.subtract(BigDecimal.valueOf(10)), "saldo Sender")
                    );
        });
    }
}
