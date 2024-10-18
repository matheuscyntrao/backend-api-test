package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostAddItemsToCartV1Request {
    private List<PatchItemsSizeV1Request> items;
}
