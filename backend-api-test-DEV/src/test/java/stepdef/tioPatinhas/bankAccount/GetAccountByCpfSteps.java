package stepdef.tioPatinhas.bankAccount;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import mapper.tioPatinhas.bankAccount.BankAccountMapper;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import model.tioPatinhas.bankAccount.response.GetAndPutAccountByCpfV1Response;
import service.bankAccount.AccountControllerV1;
import service.crossover.cliente.Clientev2Pip;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;

public class GetAccountByCpfSteps {
    @Dado("possuo dados para BankAccountService - v1 - GetCPFBankAccount:")
    public void possuoDadosParaBankAccountServiceV1GetCPFBankAccount(Map<String, String> dataTable) throws JsonProcessingException {
       System.out.println(dataTable);
        BuilderRequest.path.accept(Util.rota.apply(AccountControllerV1.GET_ACCOUNT_BY_CPF), dataTable);
    }

    @Quando("executo BankAccountService - v1 - GetAccount")
    public void executoBankAccountServiceV1GetAccount() {
        AccountControllerV1.getAccountByCpf.accept(Cache.valores.get(Util.rota.apply("TOKEN")));
    }

    @Entao("sistema processa BankAccountService - v1 - GetAccountStatus:")
    public void sistemaProcessaBankAccountServiceV1GetAccountStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(AccountControllerV1.GET_ACCOUNT_BY_CPF)).getServiceResponse()
                , GetAndPutAccountByCpfV1Response.class
        );
    }

    @E("valido BankAccountService - v1 - ValidaDados")
    public void validoBankAccountServiceVValidaDados() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(AccountControllerV1.GET_ACCOUNT_BY_CPF)).getServiceResponse().getStatusCode() == 200, () -> {
            GetAndPutAccountByCpfV1Response retornado = Cache.chamadas.get(Util.rota.apply(AccountControllerV1.GET_ACCOUNT_BY_CPF)).getServiceResponse()
                    .getObjectBody(GetAndPutAccountByCpfV1Response.class);

            List<GetClientePipClientesCpfResponse_v2> clientePip = Arrays.asList(Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse()
                    .getObjectBody(GetClientePipClientesCpfResponse_v2[].class));
            GetAndPutAccountByCpfV1Response esperado = BankAccountMapper.mapCustomerDataToAccountModel(clientePip.get(0));

            assertAll(
                    () -> assertEquals(retornado.getBillingAddress().getAddress(), esperado.getBillingAddress().getAddress(), "getAddress"),
                    () -> assertEquals(retornado.getBillingAddress().getCity(), esperado.getBillingAddress().getCity(), "getCity"),
                    () -> assertEquals(retornado.getBillingAddress().getComplement(), esperado.getBillingAddress().getComplement(), "getComplement"),
                    () -> assertEquals(retornado.getBillingAddress().getCountry(), esperado.getBillingAddress().getCountry(), "getCountry"),
                    () -> assertEquals(retornado.getBillingAddress().getDistrict(), esperado.getBillingAddress().getDistrict(), "getDistrict"),
                    () -> assertEquals(retornado.getBillingAddress().getNumber(), esperado.getBillingAddress().getNumber(), "getNumber"),
                    () -> assertEquals(retornado.getBillingAddress().getState(), esperado.getBillingAddress().getState(), "getState"),
                    () -> assertEquals(retornado.getBillingAddress().getZipCode(), esperado.getBillingAddress().getZipCode(), "getZipCode"),

                    //() -> assertEquals(retornado.getClient().getBirthDate(), esperado.getClient().getBirthDate(), "getBirthDate"),
                    () -> assertEquals(retornado.getClient().getEmail(), esperado.getClient().getEmail(), "getEmail"),
                    //() -> assertEquals(retornado.getClient().getMailAddress(), esperado.getClient().getMailAddress(), "getMailAddress"),
                    () -> assertEquals(retornado.getClient().getMother(), esperado.getClient().getMother(), "getMother"),
                    () -> assertEquals(retornado.getClient().getName(), esperado.getClient().getName(), "getName"),
                    () -> assertEquals(retornado.getClient().getSocialName(), esperado.getClient().getSocialName(), "getSocialName"),
                    () -> assertEquals(retornado.getClient().getTaxIdentifier(), esperado.getClient().getTaxIdentifier(), "getTaxIdentifier")
            );
        });
    }
}
