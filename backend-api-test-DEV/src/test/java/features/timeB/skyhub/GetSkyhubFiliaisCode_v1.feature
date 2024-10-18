#language: pt
@skyhub-filiais @skyhub-token
Funcionalidade: Skyhub-v1-GetFiliaisCode

  Esquema do Cenario: Get Skyhub Filiais Code v1 <fluxo>
    Dado possuo dados para Skyhub - v1 - GetFiliaisCode path:
      | code | <code> |
    Quando executo Skyhub - v1 - GetFiliaisCode
    Entao sistema processa Skyhub - v1 - GetFiliaisCode:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | code | statusCode |
      | FB    | 31   | 200        |