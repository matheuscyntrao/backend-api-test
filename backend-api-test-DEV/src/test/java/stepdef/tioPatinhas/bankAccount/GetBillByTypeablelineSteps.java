package stepdef.tioPatinhas.bankAccount;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.tioPatinhas.bankAccount.response.GetBillByTypeablelineV1Response;
import service.bankAccount.BillControllerV1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

public class GetBillByTypeablelineSteps {

    @Dado("possuo dados para BankAccountService - v1 - GetTypeableline:")
    public void possuoDadosParaBankAccountServiceV1GetTypeableline(DataTable dataTable) throws JsonProcessingException {
        String typeableline = dataTable.asLists().get(1).get(0);
        Cache.valores.put(Util.rota.apply("TYPEABLELINE"), typeableline);
    }

    @Quando("executo BankAccountService - v1 - GetBill")
    public void executoBankAccountServiceV1GetBill(){
        Map<String, String> pathTypeableLine = new HashMap<>();
        pathTypeableLine.put("typeableline",Cache.valores.get(Util.rota.apply("TYPEABLELINE")));
        BuilderRequest.path.accept(Util.rota.apply(BillControllerV1.GET_BILL_BY_TYPEABLELINE),pathTypeableLine);
        BillControllerV1.getBillByTypeableline.run();
    }

    @Entao("sistema processa BankAccountService - v1 - GetBillStatus:")
    public void sistemaProcessaBankAccountServiceV1GetBillStatus(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(BillControllerV1.GET_BILL_BY_TYPEABLELINE)).getServiceResponse()
                , GetBillByTypeablelineV1Response.class
        );
    }
}
