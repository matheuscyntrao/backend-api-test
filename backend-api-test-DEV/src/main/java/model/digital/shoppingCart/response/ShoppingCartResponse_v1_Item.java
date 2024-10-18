package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;
import model.digital.shoppingCart.enums.ItemTagsEnum;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Item {
    private String code;
    private Long panvelCode;
    private Double originalPrice;
    private String productName;
    @Valid
    private ShoppingCartResponse_v1_Item_Discount discount;
    @Valid
    private ShoppingCartResponse_v1_Item_Prescription prescription;
    private ItemTagsEnum tags[];
    private Boolean newItem;
    private String image;
}
