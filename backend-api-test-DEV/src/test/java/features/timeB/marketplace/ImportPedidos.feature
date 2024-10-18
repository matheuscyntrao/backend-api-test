#language: pt
@pedido-service @marketplace @pedidos-marketplace
Funcionalidade: Import de pedidos Marketplace - v1

  Esquema do Cenario: Import de pedidos Marketplace - v1 <fluxo>
    Dado que possuo dados para MarketplaceSeller - v1 - Import de pedidos:
      | fluxo | <fluxo> |
    Quando executo MarketplaceSeller - v1 - Import de pedidos
    E sistema processa Pedido - v2 - GetPedidoImportMarketplace:
      | statusCode | <statusCode> |
    E valido Pedido - v2 - GetPedido Marketplace
      | fluxo          | <fluxo>          |
      | origemDesconto | <origemDesconto> |
      | taxaJuros      | <taxaJuros>      |

    @FB @regressao
    Exemplos:
      | fluxo          | origemDesconto | statusCode | taxaJuros |
      | PEDIDO_SIMPLES |                | 200        |           |

    @FA
    Exemplos:
      | fluxo                                            | origemDesconto | statusCode | taxaJuros |
      | PEDIDO_CLIENTE_CADASTRADO_PROGRAMADA             |                | 200        |           |
      | PEDIDO_CLIENTE_CADASTRADO_PAC                    |                | 200        |           |
      | PEDIDO_CLIENTE_CADASTRADO_SEDEX                  |                | 200        |           |
      | PEDIDO_CLIENTE_CADASTRADO_LOCALIDADE             |                | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_PROGRAMADA         |                | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_PAC                |                | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_SEDEX              |                | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_LOCALIDADE         |                | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_SEM_MATCH          |                | 200        |           |
      | PEDIDO_VALIDA_ALTERACAO_REGRA_PROGRAMADA_MOTOBOY |                | 200        |           |
      | PEDIDO_VALIDA_ALTERACAO_REGRA_CORREIOS_PAC       |                | 200        |           |
      | PEDIDO_VALIDA_ALTERACAO_REGRA_CORREIOS_SEDEX     |                | 200        |           |
      | PEDIDO_CLIENTE_CADASTRADO_COM_DESCONTO           | 22             | 200        |           |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_COM_DESCONTO       | 22             | 200        |           |
      | PEDIDO_CLIENTE_CADASTRADO_COM_JUROS              |                | 200        | 2         |
      | PEDIDO_CLIENTE_NAO_CADASTRADO_COM_JUROS          |                | 200        | 2         |

