package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_FormaPagamentoConvenio_DocumentoConvenio {
    private BigInteger sequenciaDocumentoPedido;
    private BigInteger numeroPedido;
    private String descricaoDocumento;
    private BigInteger filialConvenio;
    private BigInteger convenio;
    private BigInteger tipoDocumento;
    private String descricaoTipoDocumento;
}
