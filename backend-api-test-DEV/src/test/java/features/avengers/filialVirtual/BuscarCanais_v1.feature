#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Buscar Lista de Canais - v1

  @FB @regressao
  Cenario: Buscar Lista de Canais - v1 FB - Todos
    Dado possuo dados para FilialVirtual - v1 - GetCanais
    Quando executo FilialVirtual - v1 - GetCanais
    Entao sistema processa FilialVirtual - v1 - GetCanais:
      | statusCode | 200 |
    E valido FilialVirtual - v1 - GetCanais