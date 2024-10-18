#language: pt
@pedido-ecommerce-service
Funcionalidade: PedidoEcommerce-v1-PostPedido

  Esquema do Cenario: PedidoEcommerce-v1-PostPedido - <fluxo>
    Dado que possuo dados para PedidoEcommerce - v1 - PostPedido:
      | codigoSituacaoPedido | codigoFilial | numeroCarrinho | podePontuar | tipoPedido | origemPedido | pedidoUrgente | valorTotalPedido |
      | 17                   | 480          | 7689615        |             | I          | 5            | N             | 3.15             |
    E que possuo dados para PedidoEcommerce - v1 - PostPedido cliente:
      | codigoCliente | ddd | telefone  | cpf |
      | 7156451       | 51  | 989005910 |     |
    E que possuo dados para PedidoEcommerce - v1 - PostPedido enderecoEntrega:
      | codigoLocalidade | codigoLogradouro | numeroEndereco | complementoEndereco | referenciaEntrega |
      | 8233             | 373514           | 234            |                     |                   |
    E que possuo dados para PedidoEcommerce - v1 - PostPedido entrega:
      | codigoFormaEntrega | codigoTipoEntrega | codigoTaxa | valorTaxa | dataHoraEntrega  | dataHoraSaidaRota |
      | 4                  | 1                 | 806200     | 0         | 10/02/2021 10:43 | 04/04/2020 13:00  |
    E que possuo dados para PedidoEcommerce - v1 - PostPedido itens:
      | codigoItem | nome | ean | quantidade | valorUnitario | valorTotal | percentualIsencao | numeroItem |
      | 127191     |      |     | 1          | 9.99          | 3.15       | 0                 | 1          |
    E que possuo dados para PedidoEcommerce - v1 - PostPedido formaPagamentoCartoes:
      | codigoFormaPagamento | tipoPagamento | valor | codigoFilialConvenio | codigoConvenio | confCodigoCondicaoPagamento | confSequenciaCondicao | idCartao | authorizerId | installmentType | installments |
      | 50                   | P             | 3.15  | 1002                 | 254487         | 2                           | 3                     | 513763   | 2            | 4               | 1            |
    Quando executo PedidoEcommerce - v1 - PostPedido
    Entao sistema processa PedidoEcommerce - v1 - PostPedido:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | statusCode |
      | FB    | 200        |


  Esquema do Cenario: PedidoEcommerce-v1-PostPedido Generate - <fluxo>
    Dado efetuo Cliente - v2 - PostCliente generate do tipo "<TIPO_CLIENTE>"
    E efetuo PedidoEcommerce - v1 - PostPedidoCarrinho cliente
    E possuo dados para PedidoEcommerce - v1 - PostPedido:
      | TIPO_PEDIDO  | <TIPO_PEDIDO>  |
      | TIPO_ENTREGA | <TIPO_ENTREGA> |


    @FB @regressao
    Exemplos:
      | fluxo | TIPO_CLIENTE     | TIPO_PEDIDO    | TIPO_ENTREGA       |
      | FB    | CLIENTE_COMPLETO | PEDIDO_SIMPLES | ENTREGA_PROGRAMADA |