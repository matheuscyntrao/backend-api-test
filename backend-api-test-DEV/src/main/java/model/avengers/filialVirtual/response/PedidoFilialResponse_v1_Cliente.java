package model.avengers.filialVirtual.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidoFilialResponse_v1_Cliente {
    private BigInteger codigoCliente;
    private String nome;
    private Integer ddd;
    private String telefone;
    private String cpf;
    private String email;
}
