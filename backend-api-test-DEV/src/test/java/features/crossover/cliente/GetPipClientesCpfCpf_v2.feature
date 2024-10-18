#language: pt
@cliente-service
Funcionalidade: Cliente-v2Pip-GetPipClientesCpfCpf


  Esquema do Cenario: Get Cliente Pip Clientes Cpf v2 - <fluxo>
    Dado possuo dados para Cliente - v2Pip - GetClientesCpf path:
      | cpf | <cpf> |
    Quando executo Cliente - v2Pip - GetClientesCpf
    Entao sistema processa Cliente - v2Pip - GetClientesCpf:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | cpf         | statusCode | message |
      | FB    | 00415559022 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                   | cpf         | statusCode | message                   |
      | FE001 - CPF invalido    | 00415559021 | 400        | CPF Inválido: 00415559021 |
      | FE002 - CPF inexistente | 43939217042 | 404        | Cliente Não Encontrado    |
