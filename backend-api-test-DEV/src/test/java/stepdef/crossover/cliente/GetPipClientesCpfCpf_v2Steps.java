package stepdef.crossover.cliente;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;
import service.crossover.cliente.Clientev2;
import service.crossover.cliente.Clientev2Pip;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class GetPipClientesCpfCpf_v2Steps {

    @Dado("possuo dados para Cliente - v2Pip - GetClientesCpf path:")
    public void possuo_dados_para_cliente_v2pip_get_clientes_cpf_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF), dataTable);
    }

    @Quando("executo Cliente - v2Pip - GetClientesCpf")
    public void executo_cliente_v2pip_get_clientes_cpf() {
        Clientev2Pip.getClientesCpfCpf.run();
    }

    @Entao("sistema processa Cliente - v2Pip - GetClientesCpf:")
    public void sistema_processa_cliente_v2pip_get_clientes_cpf(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_CPF_CPF)).getServiceResponse()
                , GetClientePipClientesCpfResponse_v2[].class
        );
    }

    @Dado("que efetuo Cliente - v2Pip - GetClientesCpf {string}")
    public void que_efetuo_cliente_v2pip_get_clientes_cpf(String cpf) {
        possuo_dados_para_cliente_v2pip_get_clientes_cpf_path(Map.of("cpf", cpf));
        executo_cliente_v2pip_get_clientes_cpf();
    }
}
