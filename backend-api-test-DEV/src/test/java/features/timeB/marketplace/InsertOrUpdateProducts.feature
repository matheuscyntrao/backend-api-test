#language: pt
@marketplace
Funcionalidade: Insere/atualiza produtos na tabela de itens Marketplace - v1

  Esquema do Cenario: Operacao na tabela de itens Marketplace - v1 <fluxo>
    Dado possuo dados para "<fluxo>" na tabela de itens Marketplace - v1
      | produto | <produto> |
    E executo "<fluxo>" na tabela de itens Marketplace - v1
      | produto | <produto> |
    Então valido "<fluxo>" do produto "<produto>" na tabela de itens Marketplace - v1

    @FB @regressao
    Exemplos:
      | fluxo  | produto |
      | INSERT | 119704  |

    @FA @regressao
    Exemplos:
      | fluxo  | produto |
      | UPDATE | 883070  |