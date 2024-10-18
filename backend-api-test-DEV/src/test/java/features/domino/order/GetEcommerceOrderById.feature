

  #language: pt
@order-service
Funcionalidade: Post Order - v1

  /*

  Obs: deve ser executado esses scripts abaixo no banco cartaotst, antes de usar o
  request acima, caso contrário será recebido uma exceção em relação ao locker:

  UPDATE ALO_RESERVAS_LOCKERS_PEDIDOS
  SET NUMERO_DO_PEDIDO = null
  WHERE NUMERO_RESERVA_LOCKER  = 10038203
  AND ID_LOCKER = 10

  UPDATE ALO_RESERVAS_LOCKERS_PEDIDOS
  SET NUMERO_DO_PEDIDO = null
  WHERE NUMERO_RESERVA_LOCKER  = 8920021
  AND ID_LOCKER = 1

  */

  Esquema do Cenario: Post Order - v1 <fluxo>


    Dado que eu execute o locker queries Order - v1 - PostEcommerceOrders

    Dado possuo dados para Order - v1 - PostEcommerceOrders "<order>"
    Quando executo Order - v1 - PostEcommerceOrders
    Entao sistema processa Order - v1 - PostEcommerceOrders:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | order         | statusCode |
      | FB    | ORDER_SIMPLES | 200        |
