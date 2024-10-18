#language: pt
@puc-service
Funcionalidade: puc-service - v1 - PutWalletItems

  Esquema do Cenario: Put Wallets Items  <fluxo>
    Dado possuo dados para WalletItems - v1 - PutWalletItems:
      | channel | subsidiary |
      | DIGITAL | 701        |
    E possuo dados para para WalletItems - v1 - PutWalletItems_Client:
      | birthDate  | cellPhone   | clientCode   | document   | email                     | name       |
      | 2018-03-29 | 45991134362 | <clientCode> | <document> | dsandre@grupodimed.com.br | meio litro |
    E possuo dados para para WalletItems - v1 - PutWalletItems_Item:
      | code   | description | ean           | grossPrice | identifier               | netPrice | programCode              |
      | 888580 | Neosaldina  | 7896015516642 | 133.34     | 607f2f7b1de3330001f9fddb | 120.01   | 607d8cc7eb55602c2062f1f9 |
    E possuo dados para para WalletItems - v1 - PutWalletItems_Item_Treatment:
      | amount   | compositionUnit   | endDate   | frequency   | frequencyUnit   | startDate   |
      | <amount> | <compositionUnit> | <endDate> | <frequency> | <frequencyUnit> | <startDate> |
    Quando executo WalletItems - v1 - PutWalletItems
    Entao sistema processa WalletItems - v1 - PutWalletItems:
      | statusCode | <statusCode> |
      | message    | <message>    |

#    @FB @regressao
#    Exemplos:
#      | fluxo      | clientCode | document    | amount | compositionUnit | endDate | frequency | frequencyUnit | startDate                | statusCode | message |
#      | AMPOLA     | 123456     | 12316724043 | 1      | AMPOLA          |         | 1         | MINUTOS       | 2021-05-14T18:25:52.756Z | 204        |         |
#      | COMPRIMIDO | 123456     | 12316724043 | 1      | COMPRIMIDO      |         | 1         | HORAS         |                          | 204        |         |
#      | CARTELA    | 123456     | 12316724043 | 1      | CARTELA         |         | 2         | DIAS          |                          | 204        |         |
#      | CAPSULA    | 123456     | 12316724043 | 1      | CAPSULA         |         | 3         | MINUTOS       |                          | 204        |         |
#      | MILILITRO  | 123456     | 12316724043 | 1      | MILILITRO       |         | 4         | HORAS         |                          | 204        |         |
#      | GOTA       | 123456     | 12316724043 | 1      | GOTA            |         | 5         | DIAS          |                          | 204        |         |
#      | JATO       | 123456     | 12316724043 | 1      | JATO            |         | 6         | MINUTOS       |                          | 204        |         |
#      | UNIDADE    | 123456     | 12316724043 | 1      | UNIDADE         |         | 7         | HORAS         |                          | 204        |         |
#      | MILIGRAMA  | 123456     | 12316724043 | 1      | MILIGRAMA       |         | 8         | DIAS          |                          | 204        |         |
#      | TIRA       | 123456     | 12316724043 | 1      | TIRA            |         | 9         | MINUTOS       |                          | 204        |         |
#      | LENCO      | 123456     | 12316724043 | 1      | LENCO           |         | 10        | HORAS         |                          | 204        |         |
#      | FLACONETE  | 123456     | 12316724043 | 1      | FLACONETE       |         | 11        | DIAS          |                          | 204        |         |
#      | DOSE       | 123456     | 12316724043 | 1      | DOSE            |         | 12        | MINUTOS       |                          | 204        |         |
#      | SACHE      | 123456     | 12316724043 | 1      | SACHE           |         | 13        | HORAS         |                          | 204        |         |
#      | GRAMA      | 123456     | 12316724043 | 1      | GRAMA           |         | 14        | DIAS          |                          | 204        |         |
#      | PASTILHA   | 123456     | 12316724043 | 1      | PASTILHA        |         | 15        | MINUTOS       |                          | 204        |         |
#      | DRAGEA     | 123456     | 12316724043 | 1      | DRAGEA          |         | 16        | HORAS         |                          | 204        |         |
#      | FRASCO     | 123456     | 12316724043 | 1      | FRASCO          |         | 17        | DIAS          |                          | 204        |         |
#      | ENVELOPE   | 123456     | 12316724043 | 1      | ENVELOPE        |         | 18        | MINUTOS       |                          | 204        |         |
#      | GOMA       | 123456     | 12316724043 | 1      | GOMA            |         | 19        | HORAS         |                          | 204        |         |

    @FE @regressao
    Exemplos:
      | fluxo                | clientCode | document    | amount | compositionUnit | endDate | frequency | frequencyUnit | startDate                | statusCode | message                                                    |
      | CLIENTE_CODE_INVALID | 1          | 12316724043 | 1      | AMPOLA          |         | 1         | MINUTOS       | 2021-05-14T18:25:52.756Z | 412        | Cpf informado pertence a uma entidade comercial diferente. |
      | DOCUMENT_INVALID     | 123456     | 12345678970 | 1      | AMPOLA          |         | 1         | MINUTOS       | 2021-05-14T18:25:52.756Z | 412        | Valor CPF invalido.                                        |
      | AMOUNT_INVALID       | 123456     | 12316724043 | 0      | AMPOLA          |         | 1         | MINUTOS       | 2021-05-14T18:25:52.756Z | 400        | valor minimo deve ser 1                                    |
      | COMPOSITION_INVALID  | 123456     | 12316724043 | 1      | TESTE           |         | 1         | MINUTOS       | 2021-05-14T18:25:52.756Z | 500        | Ocorreu um erro inesperado na aplicação                    |


