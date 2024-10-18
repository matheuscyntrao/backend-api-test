#language: pt
@pbm-gateway-service
Funcionalidade: PbmGatewayService-v1-PostAutorizacao
  Definicao da funcionalidade
  http://gitlab.dimed.com.br/varejo/analistas/user-stories/-/issues/6

  Esquema do Cenario:  PbmGatewayService - v1 - PostAutorizacao <fluxo>
    Dado que efetuo preAutorizacao do PBM "<tipoPbm>"
    E efetuo autorizacao do PBM "<tipoPbm>"
    Entao sistema processa PbmGatewayService - v1 - PostAutorizacao:
      | statusCode | <statusCode> |
      | issue      | <issue>      |
    E valido PbmGatewayService - v1 - Tabela de pbm_autorizacoes_omni
    E valido PbmGatewayService - v1 - Tabela de pbm_itens_autorizacao_omni


    @FB @regressao
    Exemplos:
      | fluxo                          | tipoPbm             | statusCode | issue |
      | CENARIO_1 - AUTORIZACAO_VALIDA | FUNCIONAL_EXISTENTE | 200        |       |
      | CENARIO_2 - AUTORIZACAO_VALIDA | EPHARMA_EXISTENTE   | 200        |       |
      | CENARIO_3 - AUTORIZACAO_VALIDA | ZICARD              | 200        |       |



