package stepdef.crossover.clienteVarejo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.clienteVarejo.response.GetClienteVarejoClientesOptInsResponse;
import org.junit.Assert;
import service.coupon.CouponCoverage_v1;
import service.crossover.clienteVarejo.ClienteVarejoV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetClientesVarejoOptinsCpf_V1Steps {

    static String ROTA = ClienteVarejoV1.GET_CLIENTES_OPT_INS_CPF;

    @Dado("possuo dados para ClienteVarejo - V1 - GetClientesOptinCpf path:")
    public void possuo_dados_para_cliente_varejo_v1_get_clientes_optin_cpf_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(ROTA), dataTable);
    }

    @Quando("executo ClienteVarejo - V1 - GetClientesOptinCpf")
    public void executo_cliente_varejo_v1_get_clientes_optin_cpf() {
        ClienteVarejoV1.getClientesOptInsCpf.run();
    }

    @Entao("sistema processa ClienteVarejo - V1 - GetClientesOptinCpf:")
    public void sistema_processa_cliente_varejo_v1_get_clientes_optin_cpf(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , GetClienteVarejoClientesOptInsResponse.class
        );
    }

    @Entao("valido {string} ClienteVarejo - V1 - GetClientesOptinCpf")
    public void valido_cliente_varejo_v1_get_clientes_optin_cpf(String esperado) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 404, () -> {
            Assert.assertEquals(esperado,Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getBody());
        });
    }
}
