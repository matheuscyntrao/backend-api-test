#language: pt
@pedido-service
Funcionalidade: Busca de Pedidos da Filial - v2

  Esquema do Cenario: Busca de Pedidos da Filial - v2 <fluxo>
    Dado possuo dados para Pedido - v2 - GetPedidosFilial path:
      | filial | 101 |
    Dado possuo dados para Pedido - v2 - GetPedidosFilial param:
      | tiposPedidos     | <tiposPedidos>     |
      | situacoesPedidos | <situacoesPedidos> |
      | dataInicial      | <dataInicial>      |
      | dataFinal        | <dataFinal>        |
    Quando executo Pedido - v2 - GetPedidosFilial
    Entao sistema processa Pedido - v2 - GetPedidosFilial:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FA @regressao
    Exemplos:
      | fluxo           | tiposPedidos     | situacoesPedidos      | dataInicial         | dataFinal           | statusCode | message |
      | FA001 - filtros | A&tiposPedidos=I | 5&situacoesPedidos=23 | 2020-08-13T00:00:01 | 2020-11-13T23:59:59 | 200        |         |

