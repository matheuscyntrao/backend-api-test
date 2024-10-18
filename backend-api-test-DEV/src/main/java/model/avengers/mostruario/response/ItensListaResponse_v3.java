package model.avengers.mostruario.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ItensListaResponse_v3 {
    @Valid
    private ItensLista_v3_Item itens[];
    @Valid
    private ItensListaResponse_v3_Pack packs[];
}
