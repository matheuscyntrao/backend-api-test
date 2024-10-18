#language: pt
@item-service
Funcionalidade: Get Itens Autocomplete - v3

  Esquema do Cenario: Get Itens Autocomplete - v3 <fluxo>
    Dado possuo dados para Item - v3 - GetItensAutocomplete param:
      | termoPesquisa | <termoPesquisa> |
      | maxResult     | <maxResult>     |
      | cep           | <cep>           |
    Quando executo Item - v3 - GetItensAutocomplete
    Entao sistema processa Item - v3 - GetItensAutocomplete:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | termoPesquisa | maxResult | cep      | statusCode | field | message |
      | FB    | PARACETAMOL   | 10        | 90680050 | 200        |       |         |
    @FE @regressao
    Exemplos:
      | fluxo                        | termoPesquisa | maxResult | cep        | statusCode | field         | message                                                                           |
      | FE001 - Termo em branco      | null          | 10        | 90680050   | 400        | termoPesquisa | Para que a busca possa ser efetuada devem ser informados pelo menos 3 caracteres. |
      | FE002 - Termo < 3 caracteres | PA            | 10        | 90680050   | 400        | termoPesquisa | size must be between 3 and 150                                                    |
      | FE003 - CEP incorreto        | PA            | 10        | 9068005000 | 404        |               | Not Found                                                                         |
