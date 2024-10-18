package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxRules {
    private BigDecimal aliquotaIcms;
    private Long codigoCfop;
    private Long codigoLegenda;
    private Long codigoSituacaoTributaria;
    private String mensagemFiscal;
    private BigDecimal percentualIsencao;
    private Long sequence;
}
