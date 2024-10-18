#language: pt
@marketplace
Funcionalidade: API fretes Marketplace - v1

  Esquema do Cenario: API fretes Marketplace - v1 <fluxo>
    Dado possuo dados para MarketplaceSeller - v1 - API fretes:
      | destinationZip   |
      | <destinationZip> |
    E possuo dados para MarketplaceSeller - v1 - API fretes volumes:
      | sku   | quantity   | price   | height   | length   | width   | weight   |
      | <sku> | <quantity> | <price> | <height> | <length> | <width> | <weight> |
    E executo MarketplaceSeller - v1 - API fretes
    Então sistema processa MarketplaceSeller - v1 - API fretes:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | statusCode | destinationZip | sku   | quantity | price | height | length | width | weight |
      | FB    | 200        | 91040360       | 17817 | 1        | 31.09 | 8.8    | 5.8    | 3.8   | 0.108  |

    @FA @regressao
    Exemplos:
      | fluxo | statusCode | destinationZip | sku   | quantity | price | height | length | width | weight |
      | FA    | 200        | 90240002       | 17817 | 1        | 31.09 | 8.8    | 5.8    | 3.8   | 0.108  |