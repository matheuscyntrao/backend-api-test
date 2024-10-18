#language: pt
@shopping-cart-service
Funcionalidade: ShoppingCart-Shipping-PostShoppingcartidLocker_v1

  Esquema do Cenario: ShoppingCart-Shipping-PostShoppingcartidLocker_v1 - <fluxo>
    Dado que executo ShoppingCart - ShoppingCart - PutShopping_v1 "<CLIENTE>"
    Dado possuo dados para ShoppingCart - Shipping - PostShoppingcartidLocker_v1:
      | lockerId   | orderNumber   |
      | <lockerId> | <orderNumber> |
    E possuo dados para ShoppingCart - Shipping - PostShoppingcartidLocker_v1 path:
      | shoppingCartId | <CARRINHO> |
    Quando executo ShoppingCart - Shipping - PostShoppingcartidLocker_v1
    Entao sistema processa ShoppingCart - Shipping - PostShoppingcartidLocker_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FE @regressao
    Exemplos:
      | fluxo                        | CLIENTE          | CARRINHO | lockerId | orderNumber | statusCode | message                                           |
      | FE001 - Sem contato          | SEM_CONTATO      | VALIDO   | 2        | 0           | 400        | Não há contato de entrega selecionado no carrinho |
      | FE002 - Sem lockerId         | NAO_IDENTIFICADO | VALIDO   | null     | 0           | 400        | Código do locker é obrigatório                    |
      | FE003 - Sem orderNumber      | NORMAL           | VALIDO   | 2        | null        | 400        | Número do pedido é obrigatório                    |
      | FE004 - Carrinho inexistente | NAO_IDENTIFICADO | INVALIDO | 2        | 0           | 404        | Carrinho não encontrado                           |
