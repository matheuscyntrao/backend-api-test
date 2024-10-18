#language: pt
@shopping-cart-service @HookPutShopping_v1
Funcionalidade: Patch ShoppingCart-Shipping-Pickup

  Esquema do Cenario: Patch ShoppingCart-Shipping-Pickup - <fluxo>
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "RANDOM"
    E que adiciono ShoppingCart - ShoppingCart - PostItemCodItem:
      | code   | productName                        |
      | 502320 | DESOD REXONA AERO MEN XTRACOOL 90G |
      | 660030 | SHAMP CLEAR 2EM1 LIMP DIARIA 400ML |
    E que verifico ShoppingCart - Shipping - GetPickup "<subsidiaryCode>"
    E possuo dados para ShoppingCart - Shipping - PatchPickup_v1:
      | pickupPersonCpf   | subsidiaryCode   |
      | <pickupPersonCpf> | <subsidiaryCode> |
    Quando executo ShoppingCart - Shipping - PatchPickup_v1
    Entao sistema processa ShoppingCart - Shipping - PatchPickup_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |
    @FB @regressao
    Exemplos:
      | fluxo | pickupPersonCpf | subsidiaryCode | statusCode | message |
      | FB    | 00644727012     | 31             | 200        |         |
