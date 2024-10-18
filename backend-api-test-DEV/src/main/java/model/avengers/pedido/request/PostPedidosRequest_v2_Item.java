package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item {
    private BigInteger codigoItem;
    private Integer numeroItem;
    private String lote;
    private Integer quantidade;
    private Integer quantidadeEntregar;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private BigDecimal codigoLiberador;
    private Double percentualIsencao;
    private String preVenda;
    private BigDecimal codigoItemAgendamento;
    private BigDecimal quantidadeEmEstoque;
    private BigDecimal codigoIav;
    private PostPedidosRequest_v2_Item_Desconto desconto;
    private PostPedidosRequest_v2_Item_Promocao promocao;
    private String contempladoConvenio;
    private Boolean vendaAntecipada;
    private Boolean itemDigitado;
    private PostPedidosRequest_v2_Item_Cassi requisicaoCassi;
    private PostPedidosRequest_v2_Item_PlanoBeneficioMedico planoBeneficioMedico;
    private List<PostPedidosRequest_v2_Item_AutorizacoesPbm> autorizacoesPbms;
    private PostPedidosRequest_v2_Item_Pack pack;
    private PostPedidosRequest_v2_Item_Receita receita;
    private BigInteger codigoQuadroOferta;
    private PostPedidosRequest_v2_Item_PedidoCd pedidoCD;
}
