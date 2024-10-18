#language: pt
@filial-service
Funcionalidade: Get Filiais Filial - v1

  Esquema do Cenario: Get Filiais Filial - v1 <fluxo>
    Dado possuo dados para Filial - v1 - GetFiliaisFilial path:
      | filial | <filial> |
    Quando executo Filial - v1 - GetFiliaisFilial
    Entao sistema processa Filial - v1 - GetFiliaisFilial:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | filial | statusCode |
      | FB    | 31    | 200        |
    @FB @regressao
    Exemplos:
      | fluxo               | filial | statusCode |
      | FE001-Não existente | 999    | 404        |