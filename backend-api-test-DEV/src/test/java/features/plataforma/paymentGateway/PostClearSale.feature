#language: pt
@gateway-pagamento-service
Funcionalidade: Plataforma - Webhook clearSale

  Esquema do Cenario: Plataforma - Webhook clearSale <fluxo>
    Dado possuo dados para Plataforma - Payment - ClearSale:
      | code   | date   | type   |
      | <code> | <date> | <type> |
    Quando executo Plataforma - Payment - ClearSale
    Entao sistema processa Plataforma - Payment - ClearSale:
      | statusCode | <statusCode> |


    @FB @regressao
    Exemplos:
      | fluxo               | code           | date       | type | statusCode |
      | FB - APA            | 12000167157415 | 2020-12-12 | APA  | 200        |
      | FB - APM            | 12000167157415 | 2020-12-12 | APM  | 200        |
      | FB - RPM            | 12000167157415 | 2020-12-12 | RPM  | 200        |
      | FB - AMA            | 12000167157415 | 2020-12-12 | AMA  | 200        |
      | FB - ERR            | 12000167157415 | 2020-12-12 | ERR  | 200        |
      | FB - NVO            | 12000167157415 | 2020-12-12 | NVO  | 200        |
      | FB - SUS            | 12000167157415 | 2020-12-12 | SUS  | 200        |
      | FB - CAN            | 12000167157415 | 2020-12-12 | CAN  | 200        |
      | FB - FRD            | 12000167157415 | 2020-12-12 | FRD  | 200        |
      | FB - RPA            | 12000167157415 | 2020-12-12 | RPA  | 200        |
      | FB - RPP            | 12000167157415 | 2020-12-12 | RPP  | 200        |
      | FB - APP            | 12000167157415 | 2020-12-12 | APP  | 200        |
      | FE-order em branco  |                | 2020-12-12 | null | 400        |
      | FE-order null       | null           | 2020-12-12 | null | 400        |
      | FE-date em branco   | 12000167157415 | 2020-12-12 | null | 400        |
      | FE-date null        | 12000167157415 | null       | null | 400        |
      | FE-Status em Branco | 12000167157415 | 2020-12-12 |      | 400        |
      | FE-Status null      | 12000167157415 | 2020-12-12 | null | 400        |

