package stepdef.domino.convenio;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.convenio.request.ConvenioBaixarSaldoRequest_v2;
import service.domino.convenio.Conveniov2;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

public class ConvenioBaixarSaldo_v2Steps {
    @Dado("^possuo dados para Convenio - v2 - PutBaixarSaldo:$")
    public void possuo_dados_para_Convenio_v2_PutBaixarSaldo(DataTable arg1) throws Throwable {
        BuilderRequest.body.accept(Util.rota.apply(Conveniov2.PUT_CONVENIO_BAIXAR_SALDO), CucumberUtils.getObjectBody(arg1, ConvenioBaixarSaldoRequest_v2.class));
    }

    @Quando("^executo Convenio - v2 - PutBaixarSaldo$")
    public void executo_Convenio_v2_PutBaixarSaldo() throws Throwable {
        Conveniov2.putConvenioBaixarSaldo.run();
    }

    @Entao("^sistema processa Convenio - v2 - PutBaixarSaldo:$")
    public void sistema_processa_Convenio_v2_PutBaixarSaldo(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Conveniov2.PUT_CONVENIO_BAIXAR_SALDO)).getServiceResponse()
                , String.class
        );
    }
}
