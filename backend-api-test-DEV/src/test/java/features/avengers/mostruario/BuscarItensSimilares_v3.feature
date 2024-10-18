#language: pt
@mostruario-service
Funcionalidade: Busca por Similares - v3

  Esquema do Cenario: Busca de produtos por Similares - v3 <fluxo>
    Dado possuo dados para Mostruario - v3 - GetSimilares path :
      | item | <item> |
    E possuo dados para Mostruario - v3 - GetSimilares param :
      | cep    | <cep>    |
      | filial | <filial> |
      | perfil | <perfil> |
    Quando executo Mostruario - v3 - GetSimilares
    Entao sistema processa Mostruario - v3 - GetSimilares:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | item  | filial | perfil | cep      | statusCode | message |
      | FB    | 92771 | 101    | 2      | 90110001 | 200        |         |
    @FA @regressao
    Exemplos:
      | fluxo              | item  | filial | perfil | cep      | statusCode | message |
      | FA001 - sem item   |       | 101    | 2      | 90110001 | 404        |         |
      | FA002 - sem filial | 92771 |        | 2      | 90110001 | 200        |         |
      | FA002 - sem cep    | 92771 | 101    | 2      |          | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo              | item  | filial | perfil | cep      | statusCode | message                       |
      | FE001 - sem perfil | 92771 | 101    |        | 90110001 | 400        | Perfil de venda é obrigatório |


