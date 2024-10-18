#language: pt
@pbm-gateway-service
Funcionalidade: PbmGatewayService-v1-PostPreAutorizacao

  Esquema do Cenario:  PbmGatewayService - v1 - PostPreAutorizacao <fluxo>

    Dado possuo dados para PbmGatewayService - v1 - PostPreAutorizacao:
      | channel   | channelOrigin   | codeProgram   | codeSubsidiary   | cpfAttendance   | cpfBeneficiary   | typeProgram   | user   |
      | <channel> | <channelOrigin> | <codeProgram> | <codeSubsidiary> | <cpfAttendance> | <cpfBeneficiary> | <typeProgram> | <user> |
    E possuo dados para PbmGatewayService - v1 - PostPreAutorizacao itemPreAuthorization:
      | codeItem  | ean   | priceGross   | priceNet   | quantityRequest   | identifier |
      | <codItem> | <ean> | <priceGross> | <priceNet> | <quantityRequest> | identifier |
    Quando executo PbmGatewayService - v1 - PostPreAutorizacao
    Entao sistema processa PbmGatewayService - v1 - PostPreAutorizacao:
      | statusCode | <statusCode> |
      | issue      | <issue>      |
    E valido PbmGatewayService - v1 - Tabela de pbm_Transacoes_Omni
    E valido PbmGatewayService - v1 - Tabela de pbm_pre_autorizacoes_omni
    E valido PbmGatewayService - v1 - Tabela de pbm_itens_pre_autorizacao_omni
    E valido o melhor preco
    @FB @regressao
    Exemplos:
      | fluxo                 | channel | channelOrigin | codeProgram | codeSubsidiary | cpfAttendance | cpfBeneficiary | codItem | ean           | priceGross | priceNet | quantityRequest | typeProgram | user    | statusCode | issue |
      | FB001 - SEVEN_CANAL_1 | 1       | STORE         | 107         | 368            | 33680223501   | 33680223501    | 880550  | 7896658030451 | 10         | 11       | 1               | I           | AUTHB2C | 201        |       |
#      | FB002 - FUNCIONAL_CANAL_1        | 1       | STORE         | 107         | 368            | 59745589012   | 02807802060    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB003 - ZICARD_CANAL_1           | 1       | STORE         | 107         | 368            | 04190456004   | 04190456004    | 117082  | 3337875560931 | 70.00      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB004 - EPHARMA_CANAL_1          | 2       | STORE         | 107         | 368            | 59745589012   | 25473930000    | 581950  | 7897705201770 | 500        | 380      | 1               | I           | AUTHB2C | 201        |       |
#      | FB005 - SEVEN_CANAL_2            | 2       | SITE          | 107         | 368            | 33680223501   | 33680223501    | 880550  | 7896658030451 | 56.54      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB006 - FUNCIONAL_CANAL_2        | 2       | SITE          | 107         | 368            | 59745589012   | 02807802060    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB007 - ZICARD_CANAL_2           | 2       | SITE          | 107         | 368            | 04190456004   | 04190456004    | 117082  | 3337875560931 | 70.00      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB008 - EPHARMA_CANAL_2          | 2       | SITE          | 107         | 368            | 59745589012   | 25473930000    | 581950  | 7897705201770 | 500        | 380      | 1               | I           | AUTHB2C | 201        |       |
     # | FB005 - APP_MELHOR_PRECO_PBM     | 1       | APP           | 107         | 368            | 33680223501   | 33680223501    | 501640  | 7896015518875 | 56.54      | 70       | 1               | I           | AUTHB2C | 201        |       |
#      | FB006 - APP_MELHOR_PRECO_PANVEL  | 1       | APP           | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB007 - SITE_MELHOR_PRECO_PBM    | 1       | SITE          | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 70       | 1               | I           | AUTHB2C | 201        |       |
#      | FB008 - SITE_MELHOR_PRECO_PANVEL | 2       | SITE          | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 70.00      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB009 - ALO_MELHOR_PRECO_PANVEL  | 2       | ALO           | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 70.00      | 15       | 1               | I           | AUTHB2C | 201        |       |
#      | FB0010 - ALO_MELHOR_PRECO_PANVEL | 2       | ALO           | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 70.00      | 15       | 1               | I           | AUTHB2C | 201        |       |
    @FE @regressao
    Exemplos:
      | fluxo | channel | channelOrigin | codeProgram | codeSubsidiary | cpfAttendance | cpfBeneficiary | codItem | ean | priceGross | priceNet | quantityRequest | typeProgram | user | statusCode | issue |
#      | FE001 - CHANNEL_INVALIDO         | 99      | SITE          | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 70       | 1               | I           | AUTHB2C | 500        | PBM Nao encontrada |
#      | FE002 - CHANNEL_NULL             |         | APP           | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 500        |                    |
#      | FE003 - CHANNEL_ORIGIN_INVALIDO  | 1       | TESTE         | 107         | 368            | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 400        |                    |
#      | FE004 - CODESUBSIDIARY_NULL      | 1       | APP           | 107         |                | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 500        |                    |
#      | FE005 - CODESUBSIDIARY_INVALIDO  | 1       | APP           | 107         | 0              | 04190456004   | 04190456004    | 501640  | 7896015518875 | 56.54      | 15       | 1               | I           | AUTHB2C | 500        | PBM Nao encontrada |


