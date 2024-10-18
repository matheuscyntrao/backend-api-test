#language: pt
@pbm-gateway-service
Funcionalidade: PbmGatewayService-v1-PostCancelamento

  Esquema do Cenario:  PbmGatewayService - v1 - PostCancelamento <fluxo>
    Dado que efetuo preAutorizacao do PBM "<tipoPbm>"
    E efetuo autorizacao do PBM "<tipoPbm>"
    E efetuo o cancelamento do PBM
    E sistema processa PbmGatewayService - v1 - PostCancelamento:
      | statusCode | <statusCode> |
    E valido PbmGatewayService - v1 - Tabela de pbm_cancelamentos_omni


    @FB @regressao
    Exemplos:
      | fluxo | tipoPbm             | statusCode |
      | FB    | FUNCIONAL_EXISTENTE | 204        |
      | FB    | ZICARD              | 204        |