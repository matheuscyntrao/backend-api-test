#language: pt
@payment-gateway-service
Funcionalidade: Plataforma - Anti fraude ClearSale

  Esquema do Cenario: E2E Anti fraude ClearSale - Cartao Armazenado <fluxo>
    Dado que crio Cliente - v2 - PostCliente "<TIPO_CLIENTE>"
    E que crio Cliente - v2 - PostClientesIdclienteCartoes "<TIPO_CARTAO>"
    E que possuo dados para Order - v1 - PostEcommerceOrders ClearSale "<ORIGEM>" e analise "<ANALISE>"
    Entao sistema processa Order - v1 - PostEcommerceOrders:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E publico Plataforma - Producer - PedidoAnalisado retornando "<STATUS>"
    E valido Qa - Pedido - Topico publicou "<TOPICOS_PUBLICADOS>"
    E valido Qa - Pedido - Topico nao publicou "<TOPICOS_NAO_PUBLICADOS>"

    @FB @regressao
    Exemplos:
      | fluxo                      | TIPO_CLIENTE        | TIPO_CARTAO   | ORIGEM    | ANALISE  | statusCode | message   | STATUS | TOPICOS_PUBLICADOS                                         | TOPICOS_NAO_PUBLICADOS                                                      |
      | 1 - Analise - Aprovacao    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | APP       | PENDENTE | 201        |           | APM    | PEDIDO-ANALISADO,PAGAMENTO-AUTORIZADO,PAGAMENTO-CONFIRMADO | PEDIDO-CANCELADO                                                            |
      | 2 - Analise - Aprovacao    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | APP    | PEDIDO-ANALISADO,PAGAMENTO-AUTORIZADO,PAGAMENTO-CONFIRMADO | PEDIDO-CANCELADO                                                            |
      | 3 - Analise - Aprovacao    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | APA    | PEDIDO-ANALISADO,PAGAMENTO-AUTORIZADO,PAGAMENTO-CONFIRMADO | PEDIDO-CANCELADO                                                            |
      | 4 - Analise - Aprovacao    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | APM    | PEDIDO-ANALISADO,PAGAMENTO-AUTORIZADO,PAGAMENTO-CONFIRMADO | PEDIDO-CANCELADO                                                            |
      | 5 - Analise - Aprovacao    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | APP    | PEDIDO-ANALISADO,PAGAMENTO-AUTORIZADO,PAGAMENTO-CONFIRMADO | PEDIDO-CANCELADO                                                            |
      | 6 - Analise                | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | NVO    | PEDIDO-ANALISADO                                           | PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                  |
      | 7 - Analise                | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | AMA    | PEDIDO-ANALISADO                                           | PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                  |
      | 8 - Analise - Reprovado    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | RPM    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 9 - Analise - Reprovado    | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | SUS    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 10 - Analise - Reprovado   | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | CAN    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 11 - Analise - Reprovado   | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | FRD    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 12 - Analise - Reprovado   | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | RPA    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 13 - Analise - Reprovado   | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | RPP    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 14 - Analise - Erro        | CLIENTE_CLEARSALE_3 | CARTAO_MASTER | ECOMMERCE | PENDENTE | 201        |           | ERR    | PEDIDO-ANALISADO,PEDIDO-CANCELADO                          | PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                                   |
      | 15 - Aprovacao Automatica  | CLIENTE_CLEARSALE_1 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        | PEDIDO-ANALISADO                                           | PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO                  |
      | 16 - Reprovacao Automatica | CLIENTE_CLEARSALE_2 | CARTAO_MASTER | APP       | PENDENTE | 412        | ClearSale |        |                                                            |                                                                             |
      | 17 - Analise               | CLIENTE_CLEARSALE_4 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 18 - Analise               | CLIENTE_CLEARSALE_5 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 19 - Analise               | CLIENTE_CLEARSALE_6 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 20 - Analise               | CLIENTE_CLEARSALE_7 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 21 - Analise               | CLIENTE_CLEARSALE_8 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 22 - Analise               | CLIENTE_CLEARSALE_9 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |
      | 23 - Analise               | CLIENTE_CLEARSALE_0 | CARTAO_MASTER | APP       | PENDENTE | 201        |           |        |                                                            | PEDIDO-ANALISADO,PEDIDO-CANCELADO,PAGAMENTO-CONFIRMADO,PAGAMENTO-AUTORIZADO |