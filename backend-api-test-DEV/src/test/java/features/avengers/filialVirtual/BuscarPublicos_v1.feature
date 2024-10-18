#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Buscar Lista de Público - v1

  @FB @regressao
  Cenario: Buscar Lista de Públicos - v1 FB - Criterio de Aceite
    Dado possuo dados para FilialVirtual - v1 - GetPublicos
    Quando executo FilialVirtual - v1 - GetPublicos
    Entao sistema processa FilialVirtual - v1 - GetPublicos:
      | statusCode | 200 |
    E valido FilialVirtual - v1 - GetPublicos
