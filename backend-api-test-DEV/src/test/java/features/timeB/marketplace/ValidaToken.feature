#language: pt
@marketplace @token
Funcionalidade: Marketplace validacao de token


  Esquema do Cenario: Validacao de Token

    Dado que efetuo MarketplaceSeller - v1 - Token "<cenario>"
    Quando executo MarketplaceSeller - v1 - Token
    Entao sistema processa MarketplaceSeller - v1 - Token:
      | statusCode | <statusCode> |
    E valido MarketplaceSeller - v1 - Token "<cenario>"

    @FB @regressao
    Exemplos:
      | cenario | statusCode |
      | valido  | 201        |

    @FE @regressao
    Exemplos:
      | cenario  | statusCode |
      | expirado | 201        |