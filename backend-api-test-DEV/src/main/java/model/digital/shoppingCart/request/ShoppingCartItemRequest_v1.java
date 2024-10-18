package model.digital.shoppingCart.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItemRequest_v1 {
    private List<ShoppingCartItemRequestv1_Itens> items;
}



