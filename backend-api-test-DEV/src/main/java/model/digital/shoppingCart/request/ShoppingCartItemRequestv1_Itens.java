package model.digital.shoppingCart.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemRequestv1_Itens {
    private Long panvelCode;
    private Integer quantity;

    public List<ShoppingCartItemRequestv1_Itens> generate(Long panvelCode, Integer quantity){
        ShoppingCartItemRequestv1_Itens[] itens = new ShoppingCartItemRequestv1_Itens[1];
        itens[0] = ShoppingCartItemRequestv1_Itens.builder().panvelCode(panvelCode).quantity(quantity).build();
        return Arrays.asList(itens.clone());
    }
}





