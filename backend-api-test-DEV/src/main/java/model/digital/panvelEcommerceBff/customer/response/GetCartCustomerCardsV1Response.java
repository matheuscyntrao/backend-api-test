package model.digital.panvelEcommerceBff.customer.response;

import lombok.Data;
import model.digital.panvelEcommerceBff.customer.response.orm.Cards;

@Data
public class GetCartCustomerCardsV1Response {
    private Cards cards;
}
