#language: pt
@skyhub-filiais @skyhub-token
Funcionalidade: Skyhub-v1-PutFiliais

  Esquema do Cenario: Put Skyhub Filiais Code v1 <fluxo>
    Dado possuo dados para Skyhub - v1 - GetFiliaisCode path:
      | code | <filial> |
    Quando executo Skyhub - v1 - GetFiliaisCode
    E possuo dados para Skuhub - v1 - PutFiliais:
      | field | <field> |
      | value | <value> |
    E possuo dados para Skyhub - v1 - PutFiliais path:
      | code | <filial> |
    Quando executo Skyhub - v1 - PutFiliais
    Entao sistema processa Skyhub - v1 - PutFiliais:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | filial | field | value  | statusCode |
      | FB    | 31     | name  | FILIAL | 204        |