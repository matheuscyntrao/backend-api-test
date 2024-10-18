package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Item {
    private BigInteger codigoItem;
    private BigInteger numeroItem;
    private BigInteger quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private String preVenda;
    private GetPedidosOrderidResponse_v1_Item_Desconto desconto;
    private GetPedidosOrderidResponse_v1_Item_Promocao promocao;
    private Boolean itemDigitado;
    private Integer quantidadeEntregar;
    private Double percentualIsencao;
    private BigInteger codigoItemAgendamento;
    private BigInteger codigoIav;
    private BigInteger quantidadeEmEstoque;
    private GetPedidosOrderidResponse_v1_Item_Liberador liberador;
    private String contempladoConvenio;
    private GetPedidosOrderidResponse_v1_Item_RequisicaoChassi requisicaoChassi;
    private GetPedidosOrderidResponse_v1_Item_PlanoBeneficioMedico planoBeneficioMedico;
    private List<GetPedidosOrderidResponse_v1_Item_AutorizacaoPbm> autorizacoesPbms;
    private GetPedidosOrderidResponse_v1_Item_Pack pack;
    private GetPedidosOrderidResponse_v1_Item_Receita receita;
    private BigInteger codigoQuadroOferta;
    private GetPedidosOrderidResponse_v1_Item_PedidoCd pedidoCD;
}
