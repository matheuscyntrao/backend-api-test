#language: pt
@item-service
Funcionalidade: Get Itens Autocomplete - v2

  Esquema do Cenario: Get Itens Autocomplete - v2 <fluxo>
    Dado possuo dados para Item - v2 - GetItensAutocomplete param:
      | nome      | <nome>      |
      | maxResult | <maxResult> |
    Quando executo Item - v2 - GetItensAutocomplete
    Entao sistema processa Item - v2 - GetItensAutocomplete:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo                 | nome        | maxResult | statusCode | message                                                            |
      | FB                    | PARACETAMOL | 10        | 200        |                                                                    |
      | FB                    | TESTE       | 3         | 200        |                                                                    |
      | FE001 - Não existente | ZMUDA       | 3         | 400        | Invalid parameter: Não foi encontrado nenhum dado para a pesquisa. |
