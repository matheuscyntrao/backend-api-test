#language: pt
@HookPutShopping_v1
Funcionalidade: E2E Shopping Cart

  Esquema do Cenario: E2E Shopping Cart Service - FB Cash
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1:
      | channel   | codCustomer   | shoppingCartId   | subsidiaryCode   |
      | <channel> | <codCustomer> | <shoppingCartId> | <subsidiaryCode> |
    E que adiciono ShoppingCart - ShoppingCart - PostItemCodItem:
      | codItem    |
      | <codItem1> |
      | <codItem2> |
    E seleciono ShoppingCart - Shipping - "<methodShipping>"
    E efetuo ShoppingCart - Payment - "<methodPayment>" de <percent>%

    Exemplos:
      | channel | codCustomer | shoppingCartId | subsidiaryCode | codItem1 | codItem2 | methodShipping | methodPayment | percent |
      | APP     | 5855628     | null           | 101            | 502320   | 660030   | PICKUP         | CASH          | 90      |
      | APP     | 5855628     | null           | 101            | 502320   | 660030   | DELIVERY       | CASH          | 90      |
