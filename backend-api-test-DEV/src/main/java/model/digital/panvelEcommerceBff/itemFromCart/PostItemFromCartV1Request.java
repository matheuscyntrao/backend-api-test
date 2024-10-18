package model.digital.panvelEcommerceBff.itemFromCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.PatchItemsSizeV1Request;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostItemFromCartV1Request {
    private List<PatchItemsSizeV1Request> items;
    private String identifier;
    private Long panvelCode;
    private Long quantity;
}
