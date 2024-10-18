package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;
import utils.PatternRegex;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
public class ShoppingCartResponse_v1 {
    private String shoppingCartId;
    private String pickupPersonCpf;
    private Boolean enable;
    private Long subsidiaryCode;
    private ChannelEnum channel;
    private Long customerCode;
    @Pattern(regexp = PatternRegex.DATE_YYYY_MM_DDTHH_MM_SS)
    private String creationDate;
    @Valid
    private ShoppingCartResponse_v1_Subsidiary subsidiary;
    @Valid
    private ShoppingCartResponse_v1_Customer customer;
    private String orderType;
    @Valid
    private ShoppingCartResponse_v1_Delivery deliveries[];
    @Valid
    private ShoppingCartResponse_v1_Item items[];
    @Valid
    private Set<ShoppingCartResponse_v1_Convenance> convenance;
    private Long codCupomDeOfertas;
    @Valid
    private ShoppingCartResponse_v1_Payment payments;
    @Valid
    private ShoppingCartResponse_v1_CartTotals cartTotals;
}
