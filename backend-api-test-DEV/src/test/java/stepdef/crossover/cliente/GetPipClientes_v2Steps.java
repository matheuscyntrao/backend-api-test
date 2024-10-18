package stepdef.crossover.cliente;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.ClientesIdResponse_v2Pip;
import org.testng.Assert;
import service.crossover.cliente.Clientev2Pip;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetPipClientes_v2Steps {
    @Dado("possuo dados para Cliente - v2Pip - GetClientesId path:")
    public void possuo_dados_para_cliente_v2pip_get_clientes_id_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Clientev2Pip.GET_CLIENTES_ID), dataTable);
    }

    @Quando("executo Cliente - v2Pip - GetClientesId")
    public void executo_cliente_v2pip_get_clientes_id() {
        Clientev2Pip.getClientesId.run();
    }

    @Entao("sistema processa Cliente - v2Pip - GetClientesId:")
    public void sistema_processa_cliente_v2pip_get_clientes_id(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_ID)).getServiceResponse()
                , ClientesIdResponse_v2Pip.class
        );
    }

    @Entao("valido {string} Cliente - v2Pip - GetClientesId")
    public void valido_cliente_v2pip_get_clientes_id(String mensagem) {
        assumingThat(!Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_ID)).getServiceResponse().getStatusCode().equals(200), () -> {
            Assert.assertEquals(Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_ID)).getServiceResponse().getBody()
                    , mensagem);
        });
    }

    public void runGetCliente(Integer cliente) {
        Map<String, String> path = new HashMap<>();
        path.put("id", cliente.toString());
        possuo_dados_para_cliente_v2pip_get_clientes_id_path(path);
        executo_cliente_v2pip_get_clientes_id();
    }

}
