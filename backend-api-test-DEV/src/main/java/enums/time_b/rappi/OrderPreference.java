package enums.time_b.rappi;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderPreference {
    UPDATE_PRODUCTS("update_products"),
    CANCEL_ORDER("cancel_order");

    private final String value;
}