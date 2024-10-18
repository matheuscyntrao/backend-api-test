#language: pt
@payment-gateway-service
Funcionalidade: Plataforma - Payment Hash

  Esquema do Cenario: Payment Hash <fluxo>
    Dado possuo dados para Plataforma - Payment - Konduto:
      | order_id   | timestamp   | status   | signature   |
      | <order_id> | <timestamp> | <status> | <signature> |
    Quando executo Plataforma - Payment - Konduto
    Entao sistema processa Plataforma - Payment - Konduto:
      | statusCode | <statusCode> |


    @FB @regressao
    Exemplos:
      | fluxo               | order_id | timestamp  | status         | signature | statusCode |
      | FE-Status em Branco | 12341    | 1608292800 |                | Zmuda     | 400        |
      | FE-Status invalido  | 12341    | 1608292800 | ZMUDA          | Zmuda     | 400        |
      | FE-Status null      | 12341    | 1608292800 | null           | Zmuda     | 400        |
      | FE-order em branco  |          | 1608292800 | NOT_ANALYZED   | Zmuda     | 400        |
      | FE-order null       | null     | 1608292800 | NOT_ANALYZED   | Zmuda     | 400        |
      | FE-timestamp null   | 12341    |            | NOT_ANALYZED   | Zmuda     | 400        |
      | FE-timestamp null   | 12341    | null       | NOT_ANALYZED   | Zmuda     | 400        |
      | FB-APPROVED         | 12341    | 1608292800 | APPROVED       | Zmuda     | 200        |
      | FE-PENDING          | 12342    | 1608292800 | PENDING        | Zmuda     | 200        |
      | FE-DECLINED         | 12343    | 1608292800 | DECLINED       | Zmuda     | 200        |
      | FE-CANCELED         | 12344    | 1608292800 | CANCELED       | Zmuda     | 200        |
      | FE-NOT_AUTHORIZED   | 12345    | 1608292800 | NOT_AUTHORIZED | Zmuda     | 200        |
      | FA-NOT_ANALYZED     | 12346    | 1608292800 | NOT_ANALYZED   | Zmuda     | 200        |


