package model.digital.panvelEcommerceBff.itemDetail;

import lombok.Data;
import model.digital.panvelEcommerceBff.itemDetail.orm.Itens;

import java.util.List;

@Data
public class GetItemSearchSuggestionsV1Response {
    private List<Itens> itens;
    private String suggestions;
}
