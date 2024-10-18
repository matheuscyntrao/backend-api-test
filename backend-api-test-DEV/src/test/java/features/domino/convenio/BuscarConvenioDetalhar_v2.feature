#language: pt
@convenio-service
Funcionalidade: Consulta Detalhe Convenio - v2

  Esquema do Cenario: Consulta Detalhe Convenio - v2 <fluxo>
    Dado possuo dados para Convenio - v2 - PostConvenioDetalhar:
      | filial   |
      | <filial> |
    Dado possuo dados para Convenio - v2 - PostConvenioDetalhar Cartoes "<cartoes>"
    Quando executo Convenio - v2 - PostConvenioDetalhar
    Entao sistema processa Convenio - v2 - PostConvenioDetalhar:
      | statusCode | <statusCode> |
      | message    | <message>    |


    @FB @regressao
    Exemplos:
      | fluxo                      | filial | cartoes          | statusCode | message |
      | COM_DEPENDENTE             | 101    | 6037230693787399 | 200        |         |
      | SEM_DEPENDENTE_TERCEIRO    | 101    | 6037230616352842 | 200        |         |
      | SEM_DEPENDENTE_FUNCIONARIO | 101    | 6037230580170972 | 200        |         |


    @FE @regressao
    Exemplos:
      | fluxo           | filial | cartoes          | statusCode | message                  |
      | CARTAO_INVALIDO | 101    | 1111111111111111 | 404        | Convenio não encontrado. |
      | CARTAO_NULL     | 101    |                  | 400        | Cartão inválido.         |
