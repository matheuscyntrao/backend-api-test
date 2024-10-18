package model.timeB.pbm.response;

import lombok.Data;

@Data
public class DesvioFluxoResponse_v4 {
    private Long codigoItem;
    private String ean;
    private String desvioFluxo;
    private String textoInformativo;
}
