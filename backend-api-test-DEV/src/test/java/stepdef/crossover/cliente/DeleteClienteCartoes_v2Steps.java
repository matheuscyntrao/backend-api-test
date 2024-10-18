package stepdef.crossover.cliente;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.authorization.response.PostAuthorizationTokenResponse_v1;
import service.crossover.cliente.Clientev2;
import service.digital.authorization.Authorizationv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class DeleteClienteCartoes_v2Steps {
    @Dado("possuo dados para Cliente - v2 - DeleteClienteCartao path:")
    public void possuo_dados_para_cliente_v2_delete_cliente_cartao_path(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(Clientev2.DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO), dataTable);
        Cache.chamadas.get(Util.rota.apply(Clientev2.DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO)).getServiceSpecs().header.put("Authorization",
                Cache.chamadas.get(Util.rota.apply(Authorizationv1.POST_AUTHORIZATION_TOKEN)).getServiceResponse().getObjectBody(PostAuthorizationTokenResponse_v1.class).getAccess_token());
    }

    @Quando("executo Cliente - v2 - DeleteClienteCartao")
    public void executo_cliente_v2_delete_cliente_cartao() {
        Clientev2.deleteClientesIdclienteCartoesIdcartao.run();
    }

    @Entao("sistema processa Cliente - v2 - DeleteClienteCartao:")
    public void sistema_processa_cliente_v2_delete_cliente_cartao(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Clientev2.DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO)).getServiceResponse()
                , String.class
        );
    }
}
