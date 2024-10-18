#language: pt
@campaign-service
Funcionalidade: Campaign-v1-GetCampaign

  Esquema do Cenario: Campaign-v1-GetCampaign - <fluxo>
    Dado que possuo dados para Campaign - v1 - GetCampaign path:
      | campaignId | <campaignId> |
    E que possuo dados para Campaign - v1 - GetCampaign param:
      | application | <application> |
    Quando executo Campaign - v1 - GetCampaign
    Entao  sistema processa Campaign - v1 - GetCampaign:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo                  | campaignId | application | statusCode |
      | FB001 ID CAMPANHA SITE | 1543       | SITE        | 200        |
      | FB002 ID CAMPANHA      | 1543       |             | 200        |

    @FE @regressao
    Exemplos:
      | fluxo                  | campaignId | application | statusCode |
      | FE001 ID INVALIDO APP  | 1543       | APP         | 404        |
      | FE001 ID INVALIDO SITE | 1234       | SITE        | 404        |
