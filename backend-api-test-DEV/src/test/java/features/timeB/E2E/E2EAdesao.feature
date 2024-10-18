#language: pt
@pbm-gateway-service
Funcionalidade: PbmGatewayService-v1-E2EPostAdesao

  Esquema do Cenario:  PbmGatewayService - v1 - E2EPostAdesao <fluxo>

    Dado que efetuo preAutorizacao do PBM "<tipoPbm>" para adesao "<tipoPrograma>"
    Quando efetuo adesao do PBM "<tipoPbm>":
    Entao sistema processa a adesao do PBM "<tipoPbm>":
      | statusCode | 200 |
    Quando efetuo preAutorizacao do PBM "<tipoPbm>"

    @FB @regressao
    Exemplos:
      | fluxo                               | tipoPbm        | tipoPrograma                        |
      | SEVEN_NOVO                          | SEVEN_NOVO     |                                     |
      | FUNCIONAL_VIVER_ZODIAC              | FUNCIONAL_NOVO | FUNCIONAL_VIVER_ZODIAC              |
      | FUNCIONAL_PROGRAMA_CUIDAR           | FUNCIONAL_NOVO | FUNCIONAL_PROGRAMA_CUIDAR           |
      | FUNCIONAL_VIVER_MAIS_GSK            | FUNCIONAL_NOVO | FUNCIONAL_VIVER_MAIS_GSK            |
      | FUNCIONAL_RECEITA_DE_VIDA           | FUNCIONAL_NOVO | FUNCIONAL_RECEITA_DE_VIDA           |
      | FUNCIONAL_PROGRAMA_VIVA             | FUNCIONAL_NOVO | FUNCIONAL_PROGRAMA_VIVA             |
      | FUNCIONAL_SOU_MAIS_VIDA             | FUNCIONAL_NOVO | FUNCIONAL_SOU_MAIS_VIDA             |
      | FUNCIONAL_ACESSAR                   | FUNCIONAL_NOVO | FUNCIONAL_ACESSAR                   |
      | FUNCIONAL_THERACLUB_THERASKIN       | FUNCIONAL_NOVO | FUNCIONAL_THERACLUB_THERASKIN       |
      | FUNCIONAL_A_CARE_ABBOTT             | FUNCIONAL_NOVO | FUNCIONAL_A_CARE_ABBOTT             |
      | FUNCIONAL_PROGRAMA_COREGA_VOCE_PODE | FUNCIONAL_NOVO | FUNCIONAL_PROGRAMA_COREGA_VOCE_PODE |
      | EPHARMA_NOVO                        | EPHARMA_NOVO   |                                     |
