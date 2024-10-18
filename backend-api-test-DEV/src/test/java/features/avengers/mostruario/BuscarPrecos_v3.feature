#language: pt
@mostruario-service
Funcionalidade: Busca de Preços - v3

  Esquema do Cenario: Busca de Preços - v3 <fluxo>
    Dado possuo dados para Mostruario - v3 - GetPrecos param :
      | filial | <filial> |
      | perfil | <perfil> |
      | ean    | <ean>    |
    Quando executo Mostruario - v3 - GetPrecos
    Entao sistema processa Mostruario - v3 - GetPrecos:
      | statusCode | <statusCode> |
      | precoVenda | <precoVenda> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | ean           | filial | perfil | statusCode | precoVenda | field | message |
      | FB    | 7893189156834 | 101    | 1      | 200        | 7.29       |       |         |
    @FA @regressao
    Exemplos:
      | fluxo                | ean           | filial | perfil | statusCode | precoVenda | field | message |
      | FA001 - outra filial | 7893189156834 | 102    | 1      | 200        | 7.29       |       |         |
    @FE @regressao
    Exemplos:
      | fluxo              | ean           | filial | perfil | statusCode | precoVenda | field  | message         |
      | FE001 - sem filial | 7893189156834 |        | 1      | 400        |            | filial | may not be null |
      | FE002 - sem perfil | 7893189156834 | 102    |        | 400        |            | perfil | may not be null |

