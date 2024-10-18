package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.ExtraInfoWrapper;
import model.digital.panvelEcommerceBff._orm.ExtraInfoWrapperContract;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchItemsSizeV1Request {
    private ExtraInfoWrapper extraInfoWrapper;
    private ExtraInfoWrapperContract extraInfoWrapperContract;
    private Long panvelCode;
    private Long quantity;
}