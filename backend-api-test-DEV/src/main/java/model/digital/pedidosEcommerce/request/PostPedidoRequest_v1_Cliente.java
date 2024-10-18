package model.digital.pedidosEcommerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPedidoRequest_v1_Cliente {
    private Long codigoCliente;
    private String nome;
    private Integer ddd;
    private String telefone;
    private String ramal;
    private String cpf;
    private String cnpj;
    private String dddRastreio;
    private String telefoneRastreio;
    private PostPedidoRequest_v1_Cliente_DadosFidelidade dadosFidelidade;
}
