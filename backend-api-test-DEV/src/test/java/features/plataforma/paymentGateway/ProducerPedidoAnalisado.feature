#language: pt
Funcionalidade: Plataforma - Producer Pedido Analisado

  Esquema do Cenario: Producer Pedido Analisado Konduto <fluxo>
    Dado possuo dados para Plataforma - Producer - PedidoAnalisado:
      | antifraudeEnum   |
      | <antifraudeEnum> |
    E possuo dados para Plataforma - Producer - PedidoAnalisado kondutoNotification:
      | orderId   | timestamp   | status   | signature   |
      | <orderId> | <timestamp> | <status> | <signature> |
    Quando executo Plataforma - Producer - PedidoAnalisado "<fluxo>"
    Entao valido Plataforma - Producer - PedidoAnalisado

    @FB @regressao
    Exemplos:
      | fluxo | antifraudeEnum | orderId  | timestamp     | status   | signature  |
      | FB    | KONDUTO        | 67019873 | 1607978825420 | APPROVED | ZmudaTeste |


  Esquema do Cenario: Producer Pedido Analisado ClearSale <fluxo>
    Dado possuo dados para Plataforma - Producer - PedidoAnalisado:
      | antifraudeEnum   |
      | <antifraudeEnum> |
    E possuo dados para Plataforma - Producer - PedidoAnalisado clearSaleNotification:
      | id   | status   | score   |
      | <id> | <status> | <score> |
    Quando executo Plataforma - Producer - PedidoAnalisado "<fluxo>"
    Entao valido Plataforma - Producer - PedidoAnalisado

    @FB @regressao
    Exemplos:
      | fluxo | antifraudeEnum | id | status | score |
      | FB    | KONDUTO        |    |        |       |
