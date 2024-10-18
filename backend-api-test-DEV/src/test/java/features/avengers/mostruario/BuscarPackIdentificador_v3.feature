#language: pt
@mostruario-service
Funcionalidade: Busca Packs através de identificador - v3

  @FB @regressao
  Cenario: Busca Packs através de identificador - v3 FB
    Dado possuo dados para Mostruario - v3 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 1          |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 100770     | 55         | 17      | 14       |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador Convenios:
      | codigoConvenio | codigoAssociado | matriculaAssociado |
      | 604011         |                 |                    |
      | 604161         |                 |                    |
    Quando executo Mostruario - v3 - PostPacksIdentificador
    Entao sistema processa Mostruario - v3 - PostPacksIdentificador:
      | statusCode    | 200                                                         |
      | codigoPack    | 23223                                                       |
      | descricaoPack | NA COMPRA DE 4 PURAN T4 62,5MCG 30CP, PAGUE R$ 10,09 CADA\n |


  @FA @regressao
  Cenario: Busca Packs através de identificador - v3 - FA001 - Sem Convenio
    Dado possuo dados para Mostruario - v3 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 1          |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 100770     | 4          | 17      | 14       |
    Quando executo Mostruario - v3 - PostPacksIdentificador
    Entao sistema processa Mostruario - v3 - PostPacksIdentificador:
      | statusCode | 200 |


  Esquema do Cenario: Busca Packs através de identificador - v3 - PostPacksIdentificador <fluxo>
    Dado possuo dados para Mostruario - v3 - PostPacksIdentificador:
      | codigoFilial   | perfilPack   |
      | <codigoFilial> | <perfilPack> |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 100770     | 3          | 17      | 14       |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador Convenios:
      | codigoConvenio | codigoAssociado | matriculaAssociado |
      | 604011         |                 |                    |
      | 604161         |                 |                    |
    Quando executo Mostruario - v3 - PostPacksIdentificador
    Entao sistema processa Mostruario - v3 - PostPacksIdentificador:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

  @FE @regressao
    Exemplos:
      | fluxo                    | codigoFilial | perfilPack | statusCode | field        | message         |
      | FE001 - sem codigoFilial |              | 1          | 400        | codigoFilial | may not be null |
      | FE002 - sem perfilPack   | 101          |            | 400        | perfilPack   | may not be null |


  Esquema do Cenario: Busca Packs através de identificador - v3 - PostPacksIdentificador-Itens <fluxo>
    Dado possuo dados para Mostruario - v3 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 1          |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador itens:
      | codigoItem   | quantidade   | precoDe   | precoPor   |
      | <codigoItem> | <quantidade> | <precoDe> | <precoPor> |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador Convenios:
      | codigoConvenio | codigoAssociado | matriculaAssociado |
      | 604011         |                 |                    |
      | 604161         |                 |                    |
    Quando executo Mostruario - v3 - PostPacksIdentificador
    Entao sistema processa Mostruario - v3 - PostPacksIdentificador:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

  @FA @regressao
    Exemplos:
      | fluxo                       | codigoItem | quantidade | precoDe | precoPor | statusCode | field | message                |
      | FA002 - quantidade 3        | 100770     | 4          | 17      | 14       | 200        |       |                        |
      | FA003 - quantidade 953      | 100770     | 953        | 17      | 14       | 200        |       |                        |
      | FA004 - quantidade negativa | 100770     | -1         | 17      | 14       | 404        |       | Nenhum pack encontrado |
      | FA005 - quantidade 0        | 100770     | 0          | 17      | 14       | 404        |       | Nenhum pack encontrado |
  @FE @regressao
    Exemplos:
      | fluxo                  | codigoItem | quantidade | precoDe | precoPor | statusCode | field      | message                  |
      | FE003 - sem codigoItem |            | 3          | 17      | 14       | 400        | codigoItem | Campo deve ser informado |
      | FE004 - sem quantidade | 100770     |            | 17      | 14       | 400        | quantidade | Campo deve ser informado |
      | FE005 - sem precoDe    | 100770     | 3          |         | 14       | 400        | precoDe    | Campo deve ser informado |
      | FE006 - sem precoPor   | 100770     | 3          | 17      |          | 400        | precoPor   | Campo deve ser informado |


  Esquema do Cenario: Busca Packs através de identificador - v3 - PostPacksIdentificador-Convenios <fluxo>
    Dado possuo dados para Mostruario - v3 - PostPacksIdentificador:
      | codigoFilial | perfilPack |
      | 101          | 1          |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador itens:
      | codigoItem | quantidade | precoDe | precoPor |
      | 100770     | 4          | 17      | 14       |
    E possuo dados para Mostruario - v3 - PostPacksIdentificador Convenios:
      | codigoConvenio   | codigoAssociado   | matriculaAssociado   |
      | <codigoConvenio> | <codigoAssociado> | <matriculaAssociado> |
    Quando executo Mostruario - v3 - PostPacksIdentificador
    Entao sistema processa Mostruario - v3 - PostPacksIdentificador:
      | statusCode    | <statusCode>    |
      | codigoPack    | <codigoPack>    |
      | descricaoPack | <descricaoPack> |

  @FA @regressao
    Exemplos:
      | fluxo                 | codigoConvenio | codigoAssociado | matriculaAssociado | statusCode | codigoPack | descricaoPack                                               |
      | FA006 - sem convenios |                |                 |                    | 200        | 23223      | NA COMPRA DE 4 PURAN T4 62,5MCG 30CP, PAGUE R$ 10,09 CADA\n |
