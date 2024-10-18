package stepdef.avengers.filialVirtual;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.filialVirtual.response.PedidoFilialResponse_v1;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

public class BuscarPedidoFilial_v1Steps {
    @Dado("^possuo dados para FilialVirtual - v1 - GetPedidoFilial path:$")
    public void possuo_dados_para_FilialVirtual_v1_GetPedidoFilial_path(Map<String, String> arg1) throws Throwable {
        BuilderRequest.path.accept(Util.rota.apply(FilialVirtualv1.GET_PEDIDO_FILIAL), arg1);
    }

    @Quando("^executo FilialVirtual - v1 - GetPedidoFilial$")
    public void executo_FilialVirtual_v1_GetPedidoFilial() throws Throwable {
        FilialVirtualv1.getPedidoFilial.run();
    }

    @Entao("^sistema processa FilialVirtual - v1 - GetPedidoFilial:$")
    public void sistema_processa_FilialVirtual_v1_GetPedidoFilial(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PEDIDO_FILIAL)).getServiceResponse()
                , PedidoFilialResponse_v1.class
        );
    }
}
