#language: pt
@pedido-service
Funcionalidade: Post Pedido Retiradas - v2

  Esquema do Cenario: Post Pedido Retiradas - v2 <fluxo>
    Dado possuo dados para Pedido - v2 - PostPedidoRetiradas:
      | matriculaOperador | <matriculaOperador> |
      | numerosPedidos    | <numerosPedidos>    |
    Quando executo Pedido - v2 - PostPedidoRetiradas
    Entao sistema processa Pedido - v2 - PostPedidoRetiradas:
      | statusCode | <statusCode> |
      | message    | <message>    |
    E valido Pedido - v2 - PostPedidoRetiradas troca de Status "<message>"

    @FB @regressao
    Exemplos:
      | fluxo          | statusCode | message | matriculaOperador | numerosPedidos |
      | FB PIP         | 204        |         | 77877             | null           |
      | FB Other Types | 204        |         | 77877             | null           |
    @FE @regressao
    Exemplos:
      | fluxo                       | statusCode | message                                                                          | matriculaOperador | numerosPedidos |
      | FE001 PIP                   | 400        | Informe os números dos pedidos que estão sendo retirados                         | 77877             | null           |
      | FE001 PIP                   | 400        | Nota de transferência PIP não emitida.                                           | 1                 | null           |
      | FE002 Matricula Errada      | 400        | Número de matrícula inválido. Para concluir, utilize outro número de matrícula." | 0                 | null           |
      | FE003 Pedido Não Encontrado | 400        | Não foi possível atualizar o status do pedido                                    | 77877             | null           |
