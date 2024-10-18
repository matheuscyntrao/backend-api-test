#language: pt
@marketplace @validaTabelaProdutosBkp
Funcionalidade: Marketplace validacao integracao de produto

  Cenario: Delete e insert na ECM_ITENS_MARKETPLACE_BKP
    Quando executo MarketPlaceSeller - v1 - LimpaTabelaBKP
    Entao  executo MarketPlaceSeller - v1 - PopulaTabelaBKP

  Esquema do Cenario: Integracao de Produtos <fluxo>
    Dado que possuo dados para MarketplaceSeller - v1 - IntegracaoProdutos
      | code   | <produtoCode> |
    E executo MarketplaceSeller - v1 - Produtos
    E valido MarketplaceSeller - v1 - Produtos
      | code   | <produtoCode> |
    Então executo MarketplaceSeller - v1 - RollbackProdutos

    @FB @regressao
    Exemplos:
      | fluxo                           | produtoCode |
      | FB - Produto_desconto_bemPanvel | 119436      |

#  Cenario: Rollback Produtos original
#    E   executo MarketplaceSeller - v1 - RollbackProdutos



