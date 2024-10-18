#language: pt
Funcionalidade: ShoppingCart-ShippingController-GetShoppingShippingLocker_v1


  Esquema do Cenario: Get Shopping Shipping Locker v1 - <fluxo>
    Dado possuo dados para ShoppingCart - Shipping - GetShoppingShippingLocker_v1 param:
      | city        | <city>        |
      | latitude    | <latitude>    |
      | longitude   | <longitude>   |
      | maxDistance | <maxDistance> |
      | state       | <state>       |
    Quando executo ShoppingCart - Shipping - GetShoppingShippingLocker_v1
    Entao sistema processa ShoppingCart - Shipping - GetShoppingShippingLocker_v1:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | city | latitude | longitude | maxDistance | state | statusCode | message |
      | FB    |      |          |           |             |       | 200        |         |
    @FA @regressao
    Exemplos:
      | fluxo          | city           | latitude   | longitude   | maxDistance | state | statusCode | message |
      | FA001-cidade   | Porto%20Alegre |            |             |             |       | 200        |         |
      | FA002-latitude |                | -30.051879 | -51.1721547 | 1           |       | 200        |         |
      | FA003-estado   |                | -30.051879 | -51.1721547 |             | RJ    | 200        |         |
    @FE
    Exemplos:
      | fluxo                    | city    | latitude | longitude | maxDistance | state | statusCode | message                  |
      | FE001-cidade inexistente | Londres |          |           |             |       | 404        | Nenhum locker encontrado |