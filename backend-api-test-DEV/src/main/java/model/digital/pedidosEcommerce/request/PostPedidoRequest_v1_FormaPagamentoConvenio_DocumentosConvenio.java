package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_FormaPagamentoConvenio_DocumentosConvenio {
    private BigInteger codigoTipoDocumento;
    private String valorDigitado;
}
