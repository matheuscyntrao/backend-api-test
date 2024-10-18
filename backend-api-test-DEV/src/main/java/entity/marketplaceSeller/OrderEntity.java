package entity.marketplaceSeller;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;

@Data
public class OrderEntity {
    private Integer idPedidoMarketplace;
    private Integer idHubMarketplace;
    private String marketplaceOrderCode;
    private BigInteger numeroDoPedido;
    private Clob jsonRecebido;
    private Date dataInclusao;
}