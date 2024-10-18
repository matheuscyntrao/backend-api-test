package queries.avengers.pedidos.orm;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Pedido {
    public BigInteger numeroDoPedido;
    public BigInteger codigoFilialTele;
    public BigInteger formaEntrega;
    public BigInteger origemDestinoEstoque;
    public BigInteger codigoSituacaoPedido;
    public BigInteger codigoCliente;
    public String nomeCliente;
    public Boolean isRetirado;
}
