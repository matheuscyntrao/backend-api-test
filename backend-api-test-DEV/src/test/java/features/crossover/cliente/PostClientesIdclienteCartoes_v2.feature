#language: pt
@cliente-service @plataforma
Funcionalidade: Cliente-v2-PostClientesIdclienteCartoes


  Esquema do Cenario: Post Clientes Idcliente Cartoes v2 - <fluxo>
    Dado possuo dados para Cliente - v2 - PostClientesIdclienteCartoes:
      | codCliente   | idCartao   | idAutorizadora   | numeroCartao   | cvvCartao   | dataExpiracaoCartao   | titular   | cartaoPrincipal   |
      | <codCliente> | <idCartao> | <idAutorizadora> | <numeroCartao> | <cvvCartao> | <dataExpiracaoCartao> | <titular> | <cartaoPrincipal> |
    Dado possuo dados para Cliente - v2 - PostClientesIdclienteCartoes path:
      | idCliente | <idCliente> |
    Quando executo Cliente - v2 - PostClientesIdclienteCartoes
    Entao sistema processa Cliente - v2 - PostClientesIdclienteCartoes:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | codCliente | idCartao | idAutorizadora | numeroCartao     | cvvCartao | dataExpiracaoCartao | titular             | cartaoPrincipal | idCliente | statusCode |
      #| FB    | 2552603    | null     | null           | 5411870101405775 | 567       | 0524                | Paulo R C SANTOS JR | S               | 2552603   | 200        |
      | FB    | 133186697    | null     | null           | 5411870101405775 | 567       | 0524                | Paulo R C SANTOS JR | S               | 133186697   | 200        |
