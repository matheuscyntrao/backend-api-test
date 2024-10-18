#language: pt
@pbm-gateway-service
Funcionalidade: PbmGatewayService-v1-PostAutorizacao
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/6

  Esquema do Cenario:  PbmGatewayService - v1 - PostAutorizacao <fluxo>

    Dado que efetuo preAutorizacao do PBM "<tipoPbm>" para adesao
    Quando efetuo adesao do PBM "<tipoPbm>":
    Entao sistema processa a adesao do PBM "<tipoPbm>":
      | statusCode | 200 |
    Quando efetuo preAutorizacao do PBM "<tipoPbm>"
    E sistema processa PbmGatewayService - v1 - PostPreAutorizacao:
      | statusCode | 201 |
    E efetuo autorizacao do PBM "<tipoPbmAut>"
    Entao sistema processa PbmGatewayService - v1 - PostAutorizacao:
      | statusCode | 200 |
    E valido PbmGatewayService - v1 - Tabela de pbm_autorizacoes_omni
    E valido PbmGatewayService - v1 - Tabela de pbm_itens_autorizacao_omni
    E efetuo o cancelamento do PBM
    E sistema processa PbmGatewayService - v1 - PostCancelamento:
      | statusCode | 204 |
    E valido PbmGatewayService - v1 - Tabela de pbm_cancelamentos_omni

    @FB @regressao
    Exemplos:
      | fluxo | tipoPbm    | tipoPbmAut      |
      | FB    | SEVEN_NOVO | SEVEN_EXISTENTE |




