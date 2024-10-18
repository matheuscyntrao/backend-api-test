#language: pt
@gateway-pagamento-service
Funcionalidade: Plataforma - Anti fraude

  Esquema do Cenario: Producer Pedido Analisado Konduto <fluxo>
    Dado que crio Cliente - v2 - PostCliente "<TIPO_CLIENTE>"
    E que crio Cliente - v2 - PostClientesIdclienteCartoes "<TIPO_CARTAO>"

    Exemplos:
      | fluxo | TIPO_CLIENTE     | TIPO_CARTAO   | TIPO_PEDIDO     |
      | FB    | CLIENTE_COMPLETO | CARTAO_MASTER | ORDER |
#
#    Dado que efetuo Cliente - v2Pip - GetClientesCpf "00415559022"
#    E que efetuo PedidoEcommerce - v1 - PostPedidoCarrinho
#    E que efetuo PedidoEcommerce - v1 - PostPedido "<antifraude>" "<cenario>"
#
#    Exemplos:
#      | fluxo             | cpf         | antifraude | cenario | statusCode |
#      | KONDUTO - SUCESSO | 01543471080 | KONDUTO    | SUCESSO |            |
#      | KONDUTO - FALHA   | 01543471080 | KONDUTO    | FALHA   |            |
#      | KONDUTO - ANALISE | 01543471080 | KONDUTO    | ANALISE |            |

#  Pagamento autoconfirmacao = true ... nao deve ser enviado para anti fraude
#    Pagamento autoconfirmacao = false
#     - Sucesso
#    - Reprovado automaticamente = 412
#    - Pendente = 201
#      webhook pagamento autorizado = publisher pagamento-confirmado
#      webhook pagamento autorizado inconsistente = avisa erro e publica novamente
#      webhook pagamento cancelado = avalia se já foi cancelado, e efetua cancelamento da pré autorizacao
#      webhook pagamento cancelado inconsistente = avisa erro e publica novamente

