#language: pt
@cliente-service
Funcionalidade: Cliente-v2Pip-GetClientesId


  Esquema do Cenario: Get Cliente Pip Clientes Id v2 - <fluxo>
    Dado possuo dados para Cliente - v2Pip - GetClientesId path:
      | id | <id> |
    Quando executo Cliente - v2Pip - GetClientesId
    Entao sistema processa Cliente - v2Pip - GetClientesId:
      | statusCode | <statusCode> |
    E valido "<message>" Cliente - v2Pip - GetClientesId

    @FB @regressao
    Exemplos:
      | fluxo | id  | statusCode | message |
      | FB    | 101 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo             | id  | statusCode | message                                                                                                            |
      | FE001-inexistente | 999 | 400        | Prezado usuário, não foi possível buscar os dados do usuário. Por favor, entre em contato com o SAC: 0800 51 1800. |