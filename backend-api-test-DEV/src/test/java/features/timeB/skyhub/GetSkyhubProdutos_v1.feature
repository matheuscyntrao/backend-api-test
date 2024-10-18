#language: pt
@skyhub-produtos
Funcionalidade: Skyhub-v1-GetProdutos

  @FB @regressao
  Cenario: Get Skyhub Produtos v1
    Dado possuo dados para Skyhub - v1 - GetProdutos
    Quando executo SkyHub - v1 - GetProdutos
    Entao sistema processa SkyHub - v1 - GetProdutos:
      | statusCode | 200 |