#language: pt
@shopping-cart-service @HookPutShopping_v1
Funcionalidade: ShoppingCart-ShippingController-PutShopping_v1

  Esquema do Cenario: Put Shopping v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Shipping - PutShopping_v1:
      | channel   | codCustomer   | shoppingCartId   | subsidiaryCode   |
      | <channel> | <codCustomer> | <shoppingCartId> | <subsidiaryCode> |
    Quando executo ShoppingCart - Shipping - PutShopping_v1
    Entao sistema processa ShoppingCart - Shipping - PutShopping_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | channel | codCustomer | shoppingCartId | subsidiaryCode | statusCode | message |
      | FB    | SITE    | 5855633     | null           | 101            | 200        |         |
    @FA @regressao
    Exemplos:
      | fluxo                               | channel     | codCustomer | shoppingCartId | subsidiaryCode | statusCode | message |
      | FA001 - Sem informar subsidiaryCode | APP         | 5855629     | null           | 101            | 200        |         |
      | FA002 - canal SITE                  | SITE        | 1269705     | null           | 101            | 200        |         |
      | FA003 - canal SITE_MOBILE           | SITE_MOBILE | 1269709     | null           | 101            | 200        |         |
      | FA004 - canal ALO                   | ALO         | 1269710     | null           | 101            | 200        |         |
      | FA005 - canal STORE                 | STORE       | 1269713     | null           | 101            | 200        |         |
      | FA006 - canal AMAZON                | AMAZON      | 1269714     | null           | 101            | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                        | channel | codCustomer | shoppingCartId | subsidiaryCode | statusCode | message             |
      | FE001 - Sem informar channel | null    | 0           | null           | 101            | 400        | channel is required |
      | FE002 - channel invalido     | ZMUDA   | 0           | null           | 101            | 400        | channel is invalid  |


  Esquema do Cenario: Put Shopping v1 - Generate
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "<TIPO_CARRINHO>"

    Exemplos:
      | TIPO_CARRINHO    |
      | NORMAL           |
      | SEM_CONTATO      |
      | NAO_IDENTIFICADO |
      | SEM_ENREDECO     |
