#language: pt
@filial-virtual-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Buscar Lista de Areas de Supervisão - v1

  @FB @regressao
  Cenario: Buscar Lista de Supervisao - v1 FB - Todos
    Dado possuo dados para FilialVirtual - v1 - GetSupervisao
    Quando executo FilialVirtual - v1 - GetSupervisao
    Entao sistema processa FilialVirtual - v1 - GetSupervisao:
      | statusCode | 200 |
    E valido FilialVirtual - v1 - GetSupervisao