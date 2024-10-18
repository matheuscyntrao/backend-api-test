package model.timeB.pbm.response;

import lombok.Data;

@Data
public class PreAutorizacaoResponse_v4_Item_DesvioFluxo {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private String textoInformativo;
    private PoliticaAdesaoResponse_v4 politicaAdesao;
}
