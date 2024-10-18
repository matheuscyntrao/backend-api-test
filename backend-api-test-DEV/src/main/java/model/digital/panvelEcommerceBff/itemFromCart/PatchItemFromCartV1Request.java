package model.digital.panvelEcommerceBff.itemFromCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchItemFromCartV1Request {
    private ExtraInfoWrapper extraInfoWrapper;
    private ExtraInfoWrapperContract extraInfoWrapperContract;
    private String identifier;
    private Long panvelCode;
    private Long quantity;
}
