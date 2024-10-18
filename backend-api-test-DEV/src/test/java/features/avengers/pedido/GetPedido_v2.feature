#language: pt
@pedido-service
Funcionalidade: Busca de Pedido - v2

  Esquema do Cenario: Busca de Pedido - v2 <fluxo>
    Dado possuo dados para Pedido - v2 - GetPedido path:
      | pedido | <pedido> |
    Quando executo Pedido - v2 - GetPedido
    Entao sistema processa Pedido - v2 - GetPedido:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | pedido   | statusCode | message |
      | FB    | 18851885 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                      | pedido    | statusCode | message               |
      | FE001 - pedido inexistente | 999209505 | 404        | Pedido não encontrado |
