#language: pt
@skyhub-produtos
Funcionalidade: MarketPlace - v1 - DeleteProdutos

  Esquema do Cenario: Delete Produtos <fluxo>

    Dado que possuo dados para MarketPlaceSeller - v1 - DeleteProdutos:
      | code | <code> |
    E que possuo o produto cadastrado - MarketPlaceSeller - v1:
      | code | <code> |
    Quando executo MarketPlaceSeller - v1 - DeleteProdutos
    Entao sistema processa MarketplaceSeller - v1 - DeleteProdutos:
      | statusCode | <statusCode> |
    E valido MarketplaceSeller - v1 - DeleteProdutos:
      | code       | <code>                  |
      | statusCode | <statusCodeAfterDelete> |

    @FB @regressao
    Exemplos:
      | fluxo                     | code   | statusCode | statusCodeAfterDelete |
      | Item com pedido vinculado | 119681 | 200        | 200                   |
      | Item com OTC e HB null    | 5401   | 200        | 404                   |