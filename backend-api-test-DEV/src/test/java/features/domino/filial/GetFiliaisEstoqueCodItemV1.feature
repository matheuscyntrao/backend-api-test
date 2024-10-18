#language: pt
@filial-service
Funcionalidade: Get Filiais Estoque CodItem - v1

  Esquema do Cenario: Get Filiais Estoque CodItem <fluxo>
    Dado possuo dados para Filial - v1 - GetFiliaisEstoqueCodItem path:
      | codItem   | <codItem>   |
      | longitude | <longitude> |
      | latitude  | <latitude>  |
      | raio      | <raio>      |
    Quando executo Filial - v1 - GetFiliaisEstoqueCodItem
    Entao sistema processa Filial - v1 - GetFiliaisEstoqueCodItem:
      | statusCode | <statusCode> |
    E valido Filial - v1 - GetFiliaisEstoqueCodItem "<message>"

    @FB @regressao
    Exemplos:
      | fluxo                                     | codItem | longitude   | latitude    | raio | statusCode | message |
      | FB001 - CONSULTA ESTOQUE ITEM TODOS PARAM | 127191  | -51.2087452 | -30.0249107 | 10.5 | 200        |         |
      | FB002 - CONSULTA ESTOQUE ITEM SO CODITEM  | 127191  |             |             |      | 200        |         |

    @FE @regressao
    Exemplos:
      | fluxo                                      | codItem | longitude   | latitude    | raio | statusCode | message                                                       |
      | FE001 - CONSULTA SEM INFORMAR LONGITUDE    | 127191  |             | -30.0249107 | 10.5 | 400        | Quando latitude for informada, a longitude deve ser informada |
      | FE002 - CONSULTA SEM INFORMAR LATITUDE     | 127191  | -51.2087452 |             | 9    | 400        | Quando longitude for informada, a latitude deve ser informada |
      | FE003 - CONSULTA CODITEM INVALIDO          | 100000  |             |             |      | 400        | Não existem lojas próximas com estoque do item.               |
      | FE004 - CONSULTA CODITEM INVALIDO LETRAS   | abcde   |             |             |      | 404        | Not Found                                                     |
      | FE005 - CONSULTA CODITEM INVALIDO CARACTER | 10-000  |             |             |      | 404        | Not Found                                                     |



