package model.avengers.mostruario.response;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class ItensDetalheResponseV3 {
    @Valid
    private List<ItensDetalheResponseV3Item> itens;
    @Valid
    private List<ItensDetalheResponseV3Packs> packs;
}
