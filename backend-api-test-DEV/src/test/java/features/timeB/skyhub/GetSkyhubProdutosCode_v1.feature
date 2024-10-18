#language: pt
@skyhub-produtos
Funcionalidade: Skyhub-v1-GetProdutosCode

  Esquema do Cenario: Get Skyhub Produtos Code v1 <fluxo>
    Dado possuo dados para Skuhub - v1 - GetProdutosCode path:
      | code | <code> |
    Quando executo Skyhub - v1 - GetProdutosCode
    Entao sistema processa Skyhub - v1 - GetProdutosCode:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | code   | statusCode |
      | FB    | 402732 | 200        |