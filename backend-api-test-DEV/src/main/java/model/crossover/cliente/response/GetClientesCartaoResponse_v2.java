package model.crossover.cliente.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetClientesCartaoResponse_v2 {
    private Long idCartao;
    private String nomeAutorizadora;
    private String mesAnoVencimento;
    private String numeroCartao;
    private String cartaoPrincipal;
    private String hashCartao;
    private String titular;
    private Long codigoConvenio;
    private Integer idAutorizadora;
}
