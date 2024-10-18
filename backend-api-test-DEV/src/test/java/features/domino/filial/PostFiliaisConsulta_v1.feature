#language: pt
@filial-service
Funcionalidade: Post Filiais Consulta - v1

  Esquema do Cenario: Post Filiais Consulta <fluxo>
    Dado possuo dados para Filial - v1 - PostFiliaisConsulta:
      | data   |
      | <data> |
    E possuo dados para Filial - v1 - PostFiliaisConsulta filiais "<filiais>":
    Quando executo Filial - v1 - PostFiliaisConsulta
    Entao sistema processa Filial - v1 - PostFiliaisConsulta:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo               | data | filiais | statusCode | message |
      | BUSCA FILIAL VALIDA | 0    | 362     | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                 | data | filiais | statusCode | message                   |
      | BUSCA FILIAL INVALIDA | 0    | 0       | 404        | Nenhuma filial encontrada |
