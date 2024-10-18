#language: pt
@skyhub-filiais @skyhub-token
Funcionalidade: Skyhub-v1-GetFiliais

  @FB @regressao
  Cenario: Get Skyhub Filiais v1
    Dado possuo dados para Skyhub - v1 - GetFiliais
    Quando executo SkyHub - v1 - GetFiliais
    Entao sistema processa SkyHub - v1 - GetFiliais:
      | statusCode | 200 |