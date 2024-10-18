#language: pt
@omnialo-backend
Funcionalidade: OmniAlo-v1-GetPagamentoPos


  Esquema do Cenario: OmniAlo-v1-GetPagamentoPos - <fluxo>
    Dado que possuo dados para OmniAlo - v1 - GetPagamentoPos path:
      | tipoEntrega  | <tipoEntrega>  |
      | formaEntrega | <formaEntrega> |
    Quando executo OmniAlo - v1 - GetPagamentoPos
    Entao  sistema processa OmniAlo - v1 - GetPagamentoPos:
      | statusCode | <statusCode> |
      | message    | <message>    |
      | field      | <field>      |

  @FB @regressao
    Exemplos:
      | fluxo | tipoEntrega | formaEntrega | statusCode | message | field |
      | FB    | 1           | 1            | 200        |         |       |

  @FE @regressao
    Exemplos:
      | fluxo | tipoEntrega | formaEntrega | statusCode | message                            | field              |
      | FE    | 2           | 1            | 400        | Entrega não permite pagamento POS. | tipoEntrega        |
      | FE    | 1           | 2            | 400        | Entrega não permite pagamento POS. | codigoFormaEntrega |
      | FE    | a           | 1            | 400        | Entrega não permite pagamento POS. | tipoEntrega        |
      | FE    | 1           | a            | 400        | Entrega não permite pagamento POS. | codigoFormaEntrega |

