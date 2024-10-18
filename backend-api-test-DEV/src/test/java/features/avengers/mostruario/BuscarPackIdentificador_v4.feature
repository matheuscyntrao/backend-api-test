#language: pt
@mostruario-service
Funcionalidade: Busca Packs através de identificador - v4

  @FB @regressao
  Cenario: Busca Packs através de identificador - v4 FB
    Dado possuo dados para Mostruario - v4 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 3          |
    E possuo dados para Mostruario - v4 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 600140     | 10         | 1.99    | 1.99     |
      | 600140     | 10         | 1.99    | 1.99     |
    Quando executo Mostruario - v4 - PostPacksIdentificador
    Entao sistema processa Mostruario - v4 - PostPacksIdentificador:
      | statusCode    | 200                               |
      | codigoPack    | 19191                             |
      | descricaoPack | LEVE 3 PAGUE 2 BARRA CEREAL NUTRY |


  Esquema do Cenario: Busca Packs através de identificador - v4 - PostPacksIdentificador <fluxo>
    Dado possuo dados para Mostruario - v4 - PostPacksIdentificador:
      | codigoFilial   | perfilPack   |
      | <codigoFilial> | <perfilPack> |
    E possuo dados para Mostruario - v4 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 600140     | 3          | 1.99    | 1.99     |
      | 600140     | 3          | 1.99    | 1.99     |
    Quando executo Mostruario - v4 - PostPacksIdentificador
    Entao sistema processa Mostruario - v4 - PostPacksIdentificador:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

  @FE @regressao
    Exemplos:
      | fluxo                    | codigoFilial | perfilPack | statusCode | field        | message         |
      | FE001 - sem codigoFilial |              | 3          | 400        | codigoFilial | may not be null |
      | FE002 - sem perfilPack   | 101          |            | 400        | perfilPack   | may not be null |


  Esquema do Cenario: Busca Packs através de identificador - v4 - itens <fluxo>
    Dado possuo dados para Mostruario - v4 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 3          |
    E possuo dados para Mostruario - v4 - PostPacksIdentificador itens:
      | codigoItem   | quantidade   | precoDe   | precoPor   |
      | <codigoItem> | <quantidade> | <precoDe> | <precoPor> |
    Quando executo Mostruario - v4 - PostPacksIdentificador
    Entao sistema processa Mostruario - v4 - PostPacksIdentificador:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

  @FA @regressao
    Exemplos:
      | fluxo                       | codigoItem | quantidade | precoDe | precoPor | statusCode | field | message |
      | FA001 - quantidade 953      | 600140     | 953        | 1.99    | 1.99     | 200        |       |         |
      | FA002 - quantidade negativa | 600140     | -1         | 1.99    | 1.99     | 200        |       |         |
      | FA003 - quantidade 0        | 600140     | 0          | 1.99    | 1.99     | 200        |       |         |
  @FE @regressao
    Exemplos:
      | fluxo                  | codigoItem | quantidade | precoDe | precoPor | statusCode | field      | message                  |
      | FE003 - sem codigoItem |            | 3          | 1.99    | 1.99     | 400        | codigoItem | Campo deve ser informado |
      | FE004 - sem quantidade | 600140     |            | 1.99    | 1.99     | 400        | quantidade | Campo deve ser informado |
      | FE005 - sem precoDe    | 600140     | 3          |         | 1.99     | 400        | precoDe    | Campo deve ser informado |
      | FE006 - sem precoPor   | 600140     | 3          | 1.99    |          | 400        | precoPor   | Campo deve ser informado |