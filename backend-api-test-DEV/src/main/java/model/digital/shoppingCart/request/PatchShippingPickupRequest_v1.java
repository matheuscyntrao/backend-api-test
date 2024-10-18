package model.digital.shoppingCart.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchShippingPickupRequest_v1 {
    private String pickupPersonCpf;
    private BigInteger subsidiaryCode;

    public static PatchShippingPickupRequest_v1 generate(){
        return PatchShippingPickupRequest_v1.builder()
                .pickupPersonCpf("00415559022")
                .subsidiaryCode(BigInteger.valueOf(701))
                .build();
    }
}

