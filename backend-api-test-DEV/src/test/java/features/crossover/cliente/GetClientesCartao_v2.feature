#language: pt
@cliente-service @plataforma
Funcionalidade: Cliente-v2-GetClientesCartao

  Esquema do Cenario: Get Clientes Cartao v2 - <fluxo>
    Dado possuo dados para Cliente - v2 - GetClientesCartao param:
      | codigoCliente | <codigoCliente> |
      | idCartao      | <idCartao>      |
    Quando executo Cliente - v2 - GetClientesCartao
    Entao sistema processa Cliente - v2 - GetClientesCartao:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo            | codigoCliente | idCartao | statusCode |
      | FB               | 2552603       | 513511   | 200        |
    @FE @regressao
    Exemplos:
      | fluxo            | codigoCliente | idCartao | statusCode |
      | FE001-Invalido   | ZMUDA         | ZMUDA    | 404        |
      | FE002-Inexistene | 959595        | 959595   | 400        |
    #TODO: Parece estar invertido o httpStatus de erro