package model.timeB.phw31tst.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVendaResponseV1 {
    private String mensagemTributos;
    private Integer quantidadeTotalItens;
    private Double valorTotal;
    private Double valorTotalDesconto;
    private Double valorTotalPagar;
    private String linkChaveAcesso;
    private String numeroChaveAcesso;
    private String numero;
    private String siglaModeloNota;
    private Integer serie;
    private String dataEmissao;
    private String protocoloAutorizacao;
    private Boolean qrCodeCentralizado;
    private String dataAutorizacao;
    private Integer numeroCupom;
    private BigInteger numeroPedido;
    private Boolean emissaoContingencia;
    private Integer documentoSaida;
    private List<PostVendaResponseV1Itens> itens;
    private PostVendaResponseV1Consumidor consumidor;
    private PostVendaResponseV1Impressora impressora;
    private PostVendaResponseV1DadosEntrega dadosEntrega;
}