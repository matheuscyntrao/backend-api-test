#language: pt
@pedido-service
Funcionalidade: Get Pedido Retiradas - v2

  Esquema do Cenario: Get Pedido Retiradas - v2 <fluxo>
    #TODO: fazer o post do pedido retirada balcão, depende de informações do negócio e conhecimento do fluxo
    Dado possuo dados para Pedido - v2 - GetPedidoRetiradas path:
      | filial | <filial> |
      | id     | <id>     |
    E possuo os Pedido - v2 - PostPedidosParaRetirada:
    Quando executo Pedido - v2 - GetPedidoRetiradas
    Entao sistema processa Pedido - v2 - GetPedidoRetiradas:
      | statusCode | <statusCode> |
      | mensagem   | <mensagem>   |
    #TODO: fazer o ultimo passo para montar o objeto do banco no padrao do response para comparação/validação
    @FB @regressao
    Exemplos:
      | fluxo       | filial | id | statusCode | mensagem |
      | FB Retirada |        |    |            |          |
    @FA @regressao
    Exemplos:
      | fluxo                        | filial | id | statusCode | mensagem |
      | FA Retirada Por Cpf          |        |    |            |          |
      | FA Retirada Por NumeroPedido |        |    |            |          |
    @FE @regressao
    Exemplos:
      #Caso não encontre, informa: "Nenhum pedido encontrado para retirada para este CPF nesta filial.
      | fluxo                                                                 | filial | id | statusCode | mensagem                                                            |
      | FE - Nenhum Pedido CPF                                                |        | 0  | 404        | "Nenhum pedido encontrado para retirada para este CPF nesta filial. |
      | FE - Nenhum Pedido CPF                                                | 0      |    | 404        | "Nenhum pedido encontrado para retirada para este CPF nesta filial. |
      #  Se a filial onde esta sendo consultado o pedido for diferente da filial de entegra/tela
      | FE - Filial Diferente de onde o pedido foi consultado.                |        |    | 400        |                                                                     |
      #  Se pedido já foi retirado (dthr_retirada diferente de nulo): Pedido já retirado na filial tele tal pelo CPF tal na data tal;
      | FE - Pedido Já Retirado                                               |        |    | 400        | Pedido já retirado na filial tele tal pelo CPF                      |
      #  Se o pedido não foi retirado: Pedido pertence a filial tal (filial tele)
      | FE - Pedido Pertence à outra Filial                                   |        |    | 400        | Pedido pertence a filial                                            |
      #  Se é da filial e já foi entregue;
      | FE - Pedido Já Retirado                                               |        |    | 400        | Pedido já retirado na filial tele tal pelo CPF                      |

      #  Se r.forma_de_entrega <> 4 (retirada balcão) e nvl(r.origem_desvio_estoque,'X') <> 'C' (não é um D+N): Pedido informado não é retirada balcão;
      | FE - Pedido já entregue retirada balcão                               |        |    | 400        | Pedido informado não é retirada balcão                              |
      #  Se  codigo_da_situacao_pedido = 5: Pedido não foi separado e faturado;
      | FE - Pedido já entregue codigo_da_situacao_pedido = 5                 |        |    | 400        | Pedido não foi separado e faturado                                  |
      #  Se codigo_da_situacao_pedido not in (6,35,41,52): Pedido encontra-se no status codigo_da_situacao_pedido (colocar a descrição);
      | FE - Pedido já entregue codigo_da_situacao_pedido not in (6,35,41,52) |        |    | 400        | Pedido encontra-se no status                                        |
