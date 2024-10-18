package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Cliente {
    private BigInteger codigoCliente;
    private String nome;
    private String ddd;
    private String telefone;
    private String email;
    private String ramal;
    private String cpf;
    private String cnpj;
    private String dddRastreio;
    private String telefoneRastreio;
    private GetPedidosOrderidResponse_v1_Cliente_DadosFidelidade dadosFidelidade;
}
