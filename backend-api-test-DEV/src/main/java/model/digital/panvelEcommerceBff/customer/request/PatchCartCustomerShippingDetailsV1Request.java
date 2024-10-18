package model.digital.panvelEcommerceBff.customer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatchCartCustomerShippingDetailsV1Request {
    private Long addressCode;
    private Long contactCode;
}
