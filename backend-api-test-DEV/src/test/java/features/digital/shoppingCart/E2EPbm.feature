#language: pt
@shopping-cart-service
Funcionalidade: E2E Shopping Cart - PBM

  Esquema do Cenario: E2E Shopping Cart Service - FB PBM
    Dado que efetuo ShoppingCart - ShoppingCart - PutShopping_v1
    E que adiciono ShoppingCart - ShoppingCart - PostItemCodItem "<ITEM_ADICIONAR>"
    E que removo ShoppingCart - ShoppingCart - PostItemCodItem "<ITEM_REMOVER>"
    Entao valido tabelas de PBM

    Exemplos:
      | channel | ITEM_ADICIONAR            | ITEM_REMOVER  |
      | APP     | PBM_FUNCIONAL,PACK        | PBM_FUNCIONAL |
#      | APP     | PBM_FUNCIONAL,PACK,NORMAL | NORMAL        |
