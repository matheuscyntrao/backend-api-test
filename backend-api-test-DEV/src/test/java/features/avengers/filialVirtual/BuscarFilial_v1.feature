#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Buscar Lista de Filiais - v1

  @FB @regressao
  Cenario: Buscar Lista de Filiais - v1 FB - Todos
    Dado possuo dados para FilialVirtual - v1 - GetFiliais
    Quando executo FilialVirtual - v1 - GetFiliais
    Entao sistema processa FilialVirtual - v1 - GetFiliais:
      | statusCode | 200 |
    E valido FilialVirtual - v1 - GetFiliais