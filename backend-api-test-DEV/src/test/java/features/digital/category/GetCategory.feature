#language: pt
@category-service
Funcionalidade: Category-v1-GetCategory

  Esquema do Cenario: Category-v1-GetCategory - <fluxo>
    Dado que possuo dados para Category - v1 - GetCategory path:
      | categoryId | <categoryId> |
    E que possuo dados para Category - v1 - GetCategory param:
      | application | <application> |
    Quando executo Category - v1 - GetCategory
    Entao  sistema processa Campaign - v1 - GetCategory:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo                  | categoryId | application | statusCode |
      | FB001 ID CATEGORY SITE | 29011      | SITE        | 200        |


    @FE @regressao
    Exemplos:
      | fluxo                  | categoryId | application | statusCode |
      | FE001 ID INVALIDO APP  | 1543       | APP         | 404        |
      | FE001 ID INVALIDO SITE | 1234       | SITE        | 404        |
