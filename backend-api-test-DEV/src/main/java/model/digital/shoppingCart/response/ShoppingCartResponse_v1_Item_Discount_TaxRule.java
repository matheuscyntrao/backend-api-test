package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Item_Discount_TaxRule {
    private Long sequence;
    private Long codigoLegenda;
    private Long codigoCfop;
    private Long codigoSituacaoTributaria;
    private Long aliquotaIcms;
    private String mensagemFiscal;
    private Double percentualIsencao;
}
