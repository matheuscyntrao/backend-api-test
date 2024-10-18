#language: pt
@authorization-service
Funcionalidade: Authorization-Token-Login

  Esquema do Cenario: Authorization-Token-Login - <fluxo>
    Dado que possuo dados para Authorization - Token - Login param:
      | grant_type | <grant_type> |
      | username   | <username>   |
      | password   | <password>   |
    Dado que possuo dados para Authorization - Token - Login header:
      | Authorization | Basic YmZmLWFwcC1wYW52ZWw6WFk3a216b056bDEwMA== |
      | app-token     | AswCtrsvwNA4                                   |
    Quando executo Authorization - Token - Login
    Entao sistema processa Authorization - Token - Login:
      | statusCode | <statusCode> |



    @FB @regressao
    Exemplos:
      | fluxo | grant_type | username                     | password                         | statusCode |
      | FB    | password   | neusinha_santos@yahoo.com.br | 0F1003EC0579BD4FB010DCBCA443F7CD | 200        |

