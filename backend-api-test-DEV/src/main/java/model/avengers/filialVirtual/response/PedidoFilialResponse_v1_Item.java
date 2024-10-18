package model.avengers.filialVirtual.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigDecimal;

@Data
public class PedidoFilialResponse_v1_Item {
    private Integer codigoItem;
    private Integer numeroItem;
    private Integer quantidade;
    private Integer quantidadeEntregar;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Double percentualIsencao;
    @Valid
    private PedidoFilialResponse_v1_ItemDesconto desconto;
    private PedidoFilialResponse_v1_ItemPromocao promocao;
    private String ean;
    private String descricao;
    private Boolean itemDigitado;
    private Boolean possuiEanImpresso;
    private Boolean obrigaLote;
}
