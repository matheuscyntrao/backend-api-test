#language: pt
@item-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: OmniDashbarodBff - v1

  Esquema do Cenario:   OmniDashbarodBff - v1 <fluxo>
    Dado possuo dados para OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos
    Quando executo OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos
    Entao sistema processa OmniDashbarodBff - v1 - GetPossiveisFiltrosAbrangenciaEOperadoresLogicos:
      | statusCode | <statusCode> |
    @FB @regressao
    Exemplos:
      | fluxo | statusCode |
      | FB    | 200        |