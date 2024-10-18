#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Buscar Lista de Bairros - v1
a
  @FB @regressao
  Cenario: Buscar Lista de Bairros - v1 FB - Todos
    Dado possuo dados para FilialVirtual - v1 - GetBairros
    Quando executo FilialVirtual - v1 - GetBairros
    Entao sistema processa FilialVirtual - v1 - GetBairros:
      | statusCode | 200 |
    E valido FilialVirtual - v1 - GetBairros