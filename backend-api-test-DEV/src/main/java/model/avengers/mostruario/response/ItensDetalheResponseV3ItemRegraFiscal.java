package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class ItensDetalheResponseV3ItemRegraFiscal {
    private Integer codigoLegenda;
    private Integer codigoCfop;
    private Integer codigoSituacaoTributaria;
    private Integer aliquotaIcms;
    private String mensagemFiscal;
    private Double percentualIsencao;
    private Boolean somaIsencaoComPromocao;

}
