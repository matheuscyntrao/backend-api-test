package model.avengers.mostruario.request;

import lombok.Data;

@Data
public class ItensListaRequest_v3_Item {
    private Integer codigo;
    private Integer quantidade;
    private Boolean isPack;
}
