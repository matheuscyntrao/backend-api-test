#language: pt
@pbm-service
Funcionalidade: E2E Fluxo Zicard PBM

  Esquema do Cenario:  E2E Fluxo de cancelamento Zicard PBM <fluxo>
    Dado que efetuo preAutorizacao do PBM zicard
    Quando efetuo autorizacao do PBM zicard
    Entao sistema processa a autorizacao do PBM zicard:
      | statusCode | 200 |
    E efetuo o cancelamento do PBM zicard
    E sistema processa o cancelamento do PBM zicard:
      | statusCode | <statusCodeCancelamento> |
    @FB @regressao
    Exemplos:
      | fluxo | statusCodeCancelamento |
      | FB    | 204                    |

  Esquema do Cenario:  E2E Fluxo de devolucao Zicard PBM <fluxo>
    Dado que efetuo preAutorizacao do PBM zicard
    Quando efetuo autorizacao do PBM zicard
    Entao sistema processa a autorizacao do PBM zicard:
      | statusCode | 200 |
    E efetuo a confirmacao do PBM zicard
    Entao sistema processa a confirmacao do PBM zicard:
      | statusCode | <statusCodeConfirmacao> |
    Quando efetuo a devolucao do PBM zicard
    Entao sistema processa a devolucao do PBM zicard:
      | statusCode | <statusCodedevolucao> |
    @FB @regressao
    Exemplos:
      | fluxo | statusCodeConfirmacao |statusCodedevolucao|
      | FB    | 200                   |200                |
