#language: pt
@skyhub-produtos
Funcionalidade: Skyhub-v1-DeleteProdutos

  Esquema do Cenario: Delete Skyhub Produtos Code v1 <fluxo>
    Dado que possuo o produto cadastrado - MarketPlaceSeller - v1:
      | code | <code> |
    Dado possuo dados para Skyhub - v1 - DeleteProdutos path:
      | code | <code> |
    Quando executo Skyhub - v1 - DeleteProdutos
    Entao sistema processa Skyhub - v1 - DeleteProdutos:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | code   | statusCode |
      | FB    | 447820 | 204        |

    @FA @regressao
    Exemplos:
      | fluxo                     | code   | statusCode |
      | Item com pedido vinculado | 119681 | 204        |
#      | Item com OTC e HB null    | 5401   | 204        |
