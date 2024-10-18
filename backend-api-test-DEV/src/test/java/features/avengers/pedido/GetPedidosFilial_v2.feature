#language: pt
@pedido-service
Funcionalidade: Busca de Pedidos da Filial - v2

  Esquema do Cenario: Busca de Pedidos da Filial - v2 <fluxo>
    Dado possuo dados para Pedido - v2 - GetPedidosFilial path:
      | filial | <filial> |
    Dado possuo dados para Pedido - v2 - GetPedidosFilial param:
      | tiposPedidos    | <tiposPedidos>    |
      | situacoesPedido | <situacoesPedido> |
    Quando executo Pedido - v2 - GetPedidosFilial
    Entao sistema processa Pedido - v2 - GetPedidosFilial:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | filial | tiposPedidos | situacoesPedido | statusCode | message |
      | FB    | 101    | F            | S               | 200        |         |
    @FA @regressao
    Exemplos:
      | fluxo                       | filial | tiposPedidos | situacoesPedido | statusCode | message |
      | FA001 - sem situacoesPedido | 101    | F            |                 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                    | filial | tiposPedidos | situacoesPedido | statusCode | message                  |
      | FE001 - sem tiposPedidos | 101    |              | S               | 400        | Tipo de pedido inválido. |
