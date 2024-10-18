package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item {
    private BigInteger codigoItem;
    private String nome;
    private String ean;
    private Integer numeroItem;
    private String lote;
    private Integer quantidade;
    private Integer quantidadeEntregar;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Double percentualIsencao;
    private String preVenda;
    private BigInteger codigoItemAgendamento;
    private BigInteger quantidadeEmEstoque;
    private PostPedidoRequest_v1_Item_Desconto desconto;
    private PostPedidoRequest_v1_Item_Promocao promocao;
    private String contempladoConvenio;
    private PostPedidoRequest_v1_RequisicaoCassi requisicaoCassi;
    private List<PostPedidoRequest_v1_Item_AutorizacaoPbm> autorizacoesPbms;
    private PostPedidoRequest_v1_Item_Pack pack;
    private  PostPedidoRequest_v1_Item_Receita receita;
    private PostPedidoRequest_v1_Item_PedidoPcd pedidoCD;
}
