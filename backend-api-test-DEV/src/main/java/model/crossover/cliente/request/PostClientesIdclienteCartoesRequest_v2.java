package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostClientesIdclienteCartoesRequest_v2 {
    private Long codCliente;
    private BigInteger idCartao;
    private Integer idAutorizadora;
    private String numeroCartao;
    private String cvvCartao;
    private String dataExpiracaoCartao;
    private String titular;
    private String cartaoPrincipal;


}