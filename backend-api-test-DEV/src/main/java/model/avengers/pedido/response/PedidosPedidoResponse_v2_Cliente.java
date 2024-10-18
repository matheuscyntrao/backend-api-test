package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Cliente {
    private BigInteger codigoCliente;
    private String nome;
    private String ddd;
    private String telefone;
    private String ramal;
    private String cpf;
    private String cnpj;
    private String dddRastreio;
    private String telefoneRastreio;
    private PedidosPedidoResponse_v2_Cliente_Fidelidade dadosFidelidade;
    private String email;
}
