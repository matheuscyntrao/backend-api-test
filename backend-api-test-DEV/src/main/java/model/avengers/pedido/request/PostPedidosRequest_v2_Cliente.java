package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Cliente {
    private BigInteger codigoCliente;
    private String nome;
    private String ddd;
    private String telefone;
    private String ramal;
    private String cpf;
    private String cnpj;
    private String dddRastreio;
    private String telefoneRastreio;
    private PostPedidosRequest_v2_Cliente_DadosFidelidade dadosFidelidade;
}
