#language: pt
@item-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Bff Coverage Possiveis Filtros Search - v1

  Esquema do Cenario:  Bff Coverage Possiveis Filtros Search - v1 <fluxo>
    Dado possuo dados para Bff Coverage - v1 - GetPossiveisFiltrosSearch:
      | coverageType | <coverageType> |
    Quando executo Bff Coverage - v1 - GetPossiveisFiltrosSearch
    Entao sistema processa Bff Coverage - v1 - GetPossiveisFiltrosSearch:
      | statusCode | <statusCode> |
    E valido Bff Coverage - v1 - GetPossiveisFiltrosSearch "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo | statusCode | coverageType    | mensagem                                        |
      | FB    | 200        | UF              |                                                 |
      | FA1   | 200        | CANAL           |                                                 |
      | FA2   | 200        | CIDADE          |                                                 |
      | FA3   | 200        | BAIRRO          |                                                 |
      | FA4   | 200        | AREA_SUPERVISAO |                                                 |
      | FA5   | 200        | PUBLICO         |                                                 |
      | FA6   | 200        | FILIAL          |                                                 |
      | FE    | 400        | JOAO            | Parâmetro de abrangência informado não é válido |