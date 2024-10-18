#language: pt
@shopping-cart-service
Funcionalidade: E2E Shopping Cart

  Esquema do Cenario: E2E Shopping Cart Service - FB Cash
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1:
      | channel | codCustomer   | shoppingCartId | subsidiaryCode |
      | APP     | <codCustomer> | null           | 101            |
    E que adiciono ShoppingCart - ShoppingCart - PostItemCodItem:
      | codItem | productName                        |
      | 502320  | DESOD REXONA AERO MEN XTRACOOL 90G |
      | 660030  | SHAMP CLEAR 2EM1 LIMP DIARIA 400ML |
    E que verifico ShoppingCart - Shipping - GetPickup "31"
    E que adiciono ShoppingCart - Shipping - PatchPickup:
      | subsidiaryCode |
      | 31             |
    E que verifico ShoppingCart - Payment - GetPayments
    E que efetuo ShoppingCart - Payment - PatchCash total
      | givenValue | paymentMethodValue |
      | 500        | 500                |


    Exemplos:
      | codCustomer |
      | 2020745     |
