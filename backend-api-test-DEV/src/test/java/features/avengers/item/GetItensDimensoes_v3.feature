#language: pt
@item-service @cupom2.0 @cupom2.0_sp1
Funcionalidade: Itens-v3-GetDimensoes

  Esquema do Cenario: Itens-v3-GetDimensoes <fluxo>
    Dado possuo dados para Item - v3 - GetItensDimensoes:
      | codigoItem | <item> |
    Quando executo Item - v3 - GetItensDimensoes
    Entao sistema processa Item - v3 - GetItensDimensoes
      | statusCode | <statusCode> |
      | message | <message> |
    E valido item - v3 - getDimensoes tabela medida_do_item

    @FB @regressao
    Exemplos:
      | fluxo                   | item                     | statusCode | message|
      | VALIDAR ITEM            | 127191                   | 200        |        |
      | VALIDAR MAIS DE UM ITEM | 127191&codigoItem=501640 | 200        |        |
    @FE @regressao
    Exemplos:
      | fluxo                  | item | statusCode | message                                     |
      | ITEM EM BRANCO         |      | 400        | Deve ser informado pelo menos um codigoItem |
      | NENHUM ITEM ENCONTRADO | 123  | 404        |                                             |

