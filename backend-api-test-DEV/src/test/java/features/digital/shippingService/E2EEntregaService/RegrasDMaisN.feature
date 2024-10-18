#language: pt
@shipping-service
Funcionalidade: ShippingService-v1-RegrasDMaisN
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/51

  Esquema do Cenario: ShippingService-v1-RegrasD+N - <fluxo>

    Dado que possuo dados para ShippingService - v1 - PostDeliveries:
      | date   | operator | origin |
      | <date> | 123456   | STORE  |
    E possuo dados para ShippingService - v1 - PostDeliveries address:
      | number | placeCode | zipCode   |
      | null   | null      | <zipCode> |
    E possuo dados para ShippingService - v1 - PostDeliveries customer:
      | code   | covenant |
      | 123456 | 132456   |
    E possuo dados para ShippingService - v1 - PostDeliveries items:
      | codeEnum   | deliver |
      | <codeEnum> | true    |
    E  possuo dados para ShippingService - v1 - PostDeliveries items groupers:
      | code   | type |
      | 123456 | PACK |
    Quando executo PostDeliveries - v1 - PostDeliveries
    Entao sistema processa PostDeliveries - v1 - PostDeliveries:
      | statusCode | <statusCode> |
    E valido PostDeliveries - v1 - PostDeliveries "<method-type>"

    @FB @regressao
    Exemplos:
      | fluxo                                | date | zipCode                 | codeEnum                | statusCode | method-type                       |
      | CENARIO 01 - RAPIDA                  | 2    | RAPIDA                  | COM_ESTOQUE             | 200        | RAPIDA-MOTOBOY                    |
      | CENARIO 01 - PROGRAMADA              | 2    | PROGRAMADA              | PBM                     | 200        | PROGRAMADA-MOTOBOY                |
      | CENARIO 02 - TELE_SEM_ESTOQUE        | 2    | TELE_DIFERENTE_DELIVERY | SEM_ESTOQUE_D_MAIS_N    | 200        | RAPIDA-MOTOBOY                    |
      | CENARIO 03 - ESTOQUE_NO_CD           | 1    | TELE_DIFERENTE_DELIVERY | ESTOQUE_DO_CD           | 200        | RAPIDA-MOTOBOY,PROGRAMADA-MOTOBOY |
      | CENARIO 04 - DELIVERY_NAO_PERMITE_CD | 1    | TELE_DIFERENTE_DELIVERY | DELIVERY_NAO_PERMITE_CD | 200        | RAPIDA-MOTOBOY,PROGRAMADA-MOTOBOY |
      | CENARIO 05 - BUSCA_ITEM_SEM_ESTOQUE  | 1    | TELE_DIFERENTE_DELIVERY | SEM_ESTOQUE             | 200        | RAPIDA-MOTOBOY,PROGRAMADA-MOTOBOY |
      | CENARIO 06 - BUSCA_ITEM_COM_BLOQUEIO | 1    | TELE_DIFERENTE_DELIVERY | COM_BLOQUEIO            | 200        | RAPIDA-MOTOBOY,PROGRAMADA-MOTOBOY |
      | CENARIO 07 - CORREIOS                | 1    | CORREIOS                | COM_ESTOQUE             | 200        | PAC-PAC                           |
      | CENARIO 08 - CORREIOS_COM_ESTOQUE_CD | 1    | CORREIOS                | CORREIO_COM_DESVIO_CD   | 200        | PAC-PAC                           |

