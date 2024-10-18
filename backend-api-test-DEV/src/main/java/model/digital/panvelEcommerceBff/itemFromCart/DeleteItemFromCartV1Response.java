package model.digital.panvelEcommerceBff.itemFromCart;

import lombok.Data;
import model.digital.panvelEcommerceBff.PatchItemsSizeV1Request;

import java.util.List;

@Data
public class DeleteItemFromCartV1Response {
    private List<PatchItemsSizeV1Request> items;
    private String identifier;
    private Long panvelCode;
    private Long quantity;
}
