package stepdef.crossover.cliente;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.GetClientesCartaoResponse_v2;
import service.crossover.cliente.Clientev2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetClientesCartao_v2Steps {
    @Dado("possuo dados para Cliente - v2 - GetClientesCartao param:")
    public void possuo_dados_para_cliente_v2_get_clientes_cartao_param(Map<String, String> dataTable) {
        BuilderRequest.param.accept(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO), dataTable);
    }

    @Quando("executo Cliente - v2 - GetClientesCartao")
    public void executo_cliente_v2_get_clientes_cartao() {
        Clientev2.getClientesCartao.run();
    }

    @Entao("sistema processa Cliente - v2 - GetClientesCartao:")
    public void sistema_processa_cliente_v2_get_clientes_cartao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2.GET_CLIENTES_CARTAO)).getServiceResponse()
                , GetClientesCartaoResponse_v2.class
        );
    }
}
