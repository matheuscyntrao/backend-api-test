package enums.digital.shoppingCart;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShoppingCartItemEnum {
    PBM {
        @Override
        public void add(String carrinho) {


        }
    },
    SIMPLES {
        @Override
        public void add(String carrinho) {

        }

    };

    public abstract void add(String carrinho);

}
