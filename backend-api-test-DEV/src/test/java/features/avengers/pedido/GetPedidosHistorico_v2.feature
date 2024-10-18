#language: pt
@pedido-service
Funcionalidade: Busca Pedidos Historico - v2

  Esquema do Cenario: Busca Pedidos Historico - v2 <fluxo>
    Dado possuo dados para Pedido - v2 - GetPedidosHistorico path:
      | cpf | <cpf> |
    Quando executo Pedido - v2 - GetPedidosHistorico
    Entao sistema processa Pedido - v2 - GetPedidosHistorico:
      | statusCode       | <statusCode>       |
      | message          | <message>          |
      | developerMessage | <developerMessage> |

    @FB @regressao
    Exemplos:
      | fluxo | cpf         | statusCode | message | developerMessage |
      | FB    | 01069192023 | 200        |         |                  |
    @FE @regressao
    Exemplos:
      | fluxo                       | cpf         | statusCode | message                            | developerMessage |
      | FE001 - cpf invalido        | 01069192021 | 404        | Não foi encontrado nenhum registro |                  |
      | FE002 - cliente inexistente | 86190779026 | 404        | Cliente não encontrado.            | 404 Not Found    |