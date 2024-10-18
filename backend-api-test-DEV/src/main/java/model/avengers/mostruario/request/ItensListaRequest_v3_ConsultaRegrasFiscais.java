package model.avengers.mostruario.request;

import lombok.Data;

@Data
public class ItensListaRequest_v3_ConsultaRegrasFiscais {
    private String uf;
    private String pais;
    private String ufDestino;
    private String paisDestino;

}
