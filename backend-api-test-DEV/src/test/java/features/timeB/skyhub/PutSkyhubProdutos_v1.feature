#language: pt
@skyhub-produtos
Funcionalidade: Skyhub-v1-PutProdutos

  Esquema do Cenario: Put Skyhub Produtos Code v1 <fluxo>
    Dado possuo dados para Skuhub - v1 - GetProdutosCode path:
      | code | <produto> |
    Quando executo Skyhub - v1 - GetProdutosCode
    E possuo dados para Skuhub - v1 - PutProdutos:
      | field | <field> |
      | value | <value> |
    E possuo dados para Skyhub - v1 - PutProdutos path:
      | code | <produto> |
    Quando executo Skyhub - v1 - PutProdutos
    Entao sistema processa Skyhub - v1 - PutProdutos:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | produto | field       | value           | statusCode |
      | FB    | 1000    | description | Update produtos | 204        |