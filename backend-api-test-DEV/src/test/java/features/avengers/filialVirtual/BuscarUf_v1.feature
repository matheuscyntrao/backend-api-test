#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
  Funcionalidade: Buscar Lista de Uf - v1

    @FB @regressao
    Cenario: Buscar Lista de Uf - v1 FB - Criterio de Aceite
      Dado possuo dados para FilialVirtual - v1 - GetUf
      Quando executo FilialVirtual - v1 - GetUf
      Entao sistema processa FilialVirtual - v1 - GetUf:
        | statusCode | 200 |
      E valido FilialVirtual - v1 - GetUf criterios aceite:
        | uf         |  RS         |

    @FA @regressao
    Cenario: Buscar Lista de Uf - v1 FA001 - Todos
      Dado possuo dados para FilialVirtual - v1 - GetUf
      Quando executo FilialVirtual - v1 - GetUf
      Entao sistema processa FilialVirtual - v1 - GetUf:
        | statusCode | 200 |
      E valido FilialVirtual - v1 - GetUf