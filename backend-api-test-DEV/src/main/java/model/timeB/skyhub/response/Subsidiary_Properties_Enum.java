package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Subsidiary_Properties_Enum {
    CONFIRM_STOCK("CONFIRM_STOCK"),
    EXPEDITION("EXPEDITION");

    private final String property;
}
