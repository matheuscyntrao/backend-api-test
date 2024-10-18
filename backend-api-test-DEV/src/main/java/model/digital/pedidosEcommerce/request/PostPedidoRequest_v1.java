package model.digital.pedidosEcommerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.response.GetClientePipClientesCpfResponse_v2;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPedidoRequest_v1 {
    private String observacao;
    private String imprimeDocumentoCupom;
    private Long codigoSituacaoPedido;
    private Long numeroCarrinho;
    private Long codigoFilial;
    private Long codigoFilialCobranca;
    private Long codigoRecurso;
    private String tipoPedido;
    private String pedidoUrgente;
    private String imprimeNfe;
    private Integer origemPedido;
    private String pedidoMultiplus;
    private BigDecimal valorTotalPedido;
    private PostPedidoRequest_v1_RequisicaoCassi requisicaoCassi;
    private PostPedidoRequest_v1_Cliente cliente;
    private PostPedidoRequest_v1_FormaPagamentoDinheiro formaPagamentoDinheiro;
    private PostPedidoRequest_v1_FormaPagamentoCaixa formaPagamentoCaixa;
    private PostPedidoRequest_v1_FormaPagamentoCheque formaPagamentoCheque;
    private PostPedidoRequest_v1_FormaPagamentoBoleto formaPagamentoBoleto;
    private PostPedidoRequest_v1_FormaPagamentoConvenio formaPagamentoConvenio;
    private PostPedidoRequest_v1_FormaPagamentoResgate formaPagamentoResgate;
    private PostPedidoRequest_v1_FormaPagamentoDebito formaPagamentoDebito;
    private List<PostPedidoRequest_v1_FormaPagamentoCartoes> formaPagamentoCartoes;
    private List<PostPedidoRequest_v1_FormaPagamentoPbm> formaPagamentoPbm;
    private PostPedidoRequest_v1_Entrega entrega;
    private PostPedidoRequest_v1_Endereco enderecoCobranca;
    private PostPedidoRequest_v1_Endereco enderecoEntrega;
    private List<PostPedidoRequest_v1_Item> itens;
    private Boolean utilizaPanvelGo;
    private Boolean podePontuar;
    private List<PostPedidoRequest_v1_ConveniosUtilizados> conveniosUtilizados;
    private Long idAssinatura;

    public void setClienteFromCadastro(PostClienteRequest_v2 cadastroCliente) {
        this.cliente = PostPedidoRequest_v1_Cliente.builder()
                .telefone(cadastroCliente.getContatos().get(0).getNumero())
                .ramal(cadastroCliente.getContatos().get(0).getRamal())
                .nome(cadastroCliente.getNome())
                .ddd(cadastroCliente.getContatos().get(0).getDdd())
                .cpf(cadastroCliente.getCpf())
                .cnpj(cadastroCliente.getCnpj())
                .codigoCliente(null)  //TODO:Ver response
                .build();
    }

    public void setEnderecoEntregaFromCliente(GetClientePipClientesCpfResponse_v2 cliente) {
        this.enderecoEntrega = PostPedidoRequest_v1_Endereco.builder()
                .codigoLocalidade(cliente.getEnderecos().get(0).getCodCidade())
                .codigoLogradouro(cliente.getEnderecos().get(0).getCodLogradouro())
                .numeroEndereco(cliente.getEnderecos().get(0).getNumero())
                .build();
    }

    public void setFormaEntregaFromEntregas() {
        this.entrega = null;
    }

}
