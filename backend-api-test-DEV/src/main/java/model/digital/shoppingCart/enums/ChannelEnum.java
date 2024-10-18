package model.digital.shoppingCart.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChannelEnum {
    APP("I", 5, 2),
    SITE("I", 3, 2),
    SITE_MOBILE("I", 1, 2),
    ALO("A", 2, 3),
    STORE(null, null, 1),
    AMAZON(null, 6, null);

    private final String orderType;
    private final Integer orderOrigin;
    private final Integer profile;
}
