#language: pt
@payment-gateway-service
Funcionalidade: Plataforma - Anti fraude Konduto

  Esquema do Cenario: E2E PedidoEcommerce - Konduto <fluxo>
    Dado que crio Cliente - v2 - PostCliente "<TIPO_CLIENTE>"
    E que crio Cliente - v2 - PostClientesIdclienteCartoes "<TIPO_CARTAO>"
    E que possuo dados para PedidoEcommerce - v1 - PostPedido Konduto "<ORIGEM>"

    @FB @regressao
    Exemplos:
      | fluxo | TIPO_CLIENTE     | TIPO_CARTAO   | ORIGEM |
      | APP   | CLIENTE_COMPLETO | CARTAO_MASTER | APP    |
      | SITE  | CLIENTE_COMPLETO | CARTAO_MASTER | SITE   |
