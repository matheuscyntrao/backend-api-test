package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExtraInfoWrapperContract {
    private PreAuthorizationWrapperContract preAuthorization;
    private Subscription subscription;
}
