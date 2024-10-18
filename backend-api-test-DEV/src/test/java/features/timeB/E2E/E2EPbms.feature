#language: pt
@pbm-service @pbm-gateway-service
Funcionalidade: E2E Fluxo Autorizacao PBM

  Esquema do Cenario:  E2E Fluxo Autorizacao PBM <tipoPbm> PRE <versaoPbmPre> AUT <versaoPbmAut> CANC <versaoPbmCancelamento>
    Dado que efetuo preAutorizacao do PBM "<tipoPbm>" na versao "<versaoPbmPre>"
    E valido preAutorizacao do PBM "<tipoPbm>" na versao "<versaoPbmPre>"
    Quando efetuo autorizacao do PBM "<tipoPbm>" na versao "<versaoPbmAut>" da "<versaoPbmPre>"
    Entao sistema processa a autorizacao do PBM "<tipoPbm>" na versao "<versaoPbmAut>":
      | statusCode | 200 |
    E efetuo o cancelamento do PBM "<tipoPbm>" na versao "<versaoPbmCancelamento>" de uma preAutorizacao "<versaoPbmPre>"
    E sistema processa o cancelamento do PBM "<tipoPbm>" na versao "<versaoPbmCancelamento>":
      | statusCode | <statusCodeCancelamento> |
      | issue      | <issue>                  |

    @FB @regressao
    Exemplos:
      | tipoPbm             | versaoPbmPre | versaoPbmAut | versaoPbmCancelamento | statusCodeCancelamento | issue |
#      | FUNCIONAL           | PBM          | PBM          | PBM                   | 204                    |       |
#      | FUNCIONAL           | PBM          | PBM          | PBM_GATEWAY           | 204                    |       |
#      | FUNCIONAL           | PBM          | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | FUNCIONAL           | PBM          | PBM_GATEWAY  | PBM_GATEWAY           | 204                    |       |

      | FUNCIONAL_EXISTENTE | PBM_GATEWAY  | PBM_GATEWAY  | PBM_GATEWAY           | 204                    |       |
#      | FUNCIONAL_EXISTENTE | PBM_GATEWAY  | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | FUNCIONAL_EXISTENTE | PBM_GATEWAY  | PBM          | PBM_GATEWAY           | 204                    |       |
#      | FUNCIONAL_EXISTENTE | PBM_GATEWAY  | PBM          | PBM                   | 204                    |       |
#
#      | ZICARD              | PBM          | PBM          | PBM                   | 204                    |       |
#      | ZICARD              | PBM          | PBM          | PBM_GATEWAY           | 204                    |       |
#      | ZICARD              | PBM          | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | ZICARD              | PBM          | PBM_GATEWAY  | PBM_GATEWAY           | 204                    |       |
#
      | ZICARD              | PBM_GATEWAY  | PBM_GATEWAY  | PBM_GATEWAY           | 204                    |       |
#      | ZICARD              | PBM_GATEWAY  | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | ZICARD              | PBM_GATEWAY  | PBM          | PBM_GATEWAY           | 204                    |       |
#      | ZICARD              | PBM_GATEWAY  | PBM          | PBM                   | 204                    |       |

      | EPHARMA_EXISTENTE | PBM_GATEWAY  | PBM_GATEWAY  |                       |                        |       |

#      | SEVEN             | PBM          | PBM          | PBM                   | 204                    |       |
#      | SEVEN             | PBM          | PBM          | PBM_GATEWAY           | 200                    |       |
#      | SEVEN             | PBM          | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | SEVEN             | PBM          | PBM_GATEWAY  | PBM_GATEWAY           | 200                    |       |

      | SEVEN_EXISTENTE     | PBM_GATEWAY  | PBM_GATEWAY  | PBM_GATEWAY           | 204                    |       |
#      | SEVEN_EXISTENTE | PBM_GATEWAY  | PBM_GATEWAY  | PBM                   | 204                    |       |
#      | SEVEN_EXISTENTE | PBM_GATEWAY  | PBM          | PBM_GATEWAY           | 200                    |       |
#      | SEVEN_EXISTENTE | PBM_GATEWAY  | PBM          | PBM                   | 204                    |       |



