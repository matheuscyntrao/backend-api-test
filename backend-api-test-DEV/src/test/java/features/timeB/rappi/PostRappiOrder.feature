#language: pt
@pedido-service @marketplace @rappi
Funcionalidade: Criar pedido Rappi MarketplaceSeller - v1

  Esquema do Cenario: Criar pedido Rappi MarketplaceSeller - v1 <fluxo>
    Dado que possuo dados para MarketplaceSeller - v1 - PostRappiOrder:
      | fluxo | <fluxo> |
    Quando executo MarketplaceSeller - v1 - PostRappiOrder
    E sistema processa MarketplaceSeller - v1 - PostRappiOrder:
      | statusCode | <statusCode> |
    Entao valido Pedido - v2 - GetPedido Marketplace Rappi
      | origemDesconto | <origemDesconto> |

    @FB @regressao
    Exemplos:
      | fluxo                     | origemDesconto | statusCode |
      | PEDIDO_CLIENTE_CADASTRADO |                | 201        |

    @FA
    Exemplos:
      | fluxo                                                     | origemDesconto | statusCode |
      | PEDIDO_CLIENTE_CADASTRADO_CEP_LOCALIDADE                  |                | 201        |
      | PEDIDO_CLIENTE_NAO_CADASTRADO                             |                | 201        |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_CEP_LOCALIDADE              |                | 201        |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_ENDERECO_SEM_MATCH_FONETICO |                | 201        |
