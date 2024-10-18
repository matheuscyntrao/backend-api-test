#language: pt
@cliente-service
Funcionalidade: Cliente-v1-GetClientesId


  Esquema do Cenario: Get Cliente Clientes Id v1 - <fluxo>
    Dado possuo dados para Cliente - v1 - GetClientesId path:
      | id | <id> |
    E possuo dados para Cliente - v1 - GetClientesId param:
      | tipo | <tipo> |
    Quando executo Cliente - v1 - GetClientesId
    Entao sistema processa Cliente - v1 - GetClientesId:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | id          | tipo | statusCode | message |
      | FB    | 72374195015 | 1    | 200        |         |

    @FA @regressao
    Exemplos:
      | fluxo | id                 | tipo | statusCode | message |
      | FA    | f.v.g@terra.com.br | 2    | 200        |         |
      | FA    | 1810819            | 0    | 200        |         |

    @FE @regressao
    Exemplos:
      | fluxo | id          | tipo | statusCode | message                |
      | FE    | 25152861003 | 1    | 404        | Cliente Não Encontrado |
      | FE    | 12345678910 | 1    | 400        | O CPF é invalido.      |