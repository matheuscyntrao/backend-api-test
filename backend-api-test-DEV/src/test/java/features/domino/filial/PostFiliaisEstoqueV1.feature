#language: pt
@filial-service
Funcionalidade: Post Filiais Estoque - v1

  Esquema do Cenario: Post Filiais Estoque <fluxo>
    Dado possuo dados para Filial - v1 - PostFiliaisEstoque:
      | filiais | <filiais> |
      | itens   | <itens>   |
    Quando executo Filial - v1 - PostFiliaisEstoque
    Entao sistema processa Filial - v1 - PostFiliaisEstoque:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB
    Exemplos:
      | fluxo                        | itens         | filiais | statusCode | message |
      | FB001 - ESTOQUE ITENS FILIAL | 127191        | 101     | 200        |         |
      | FB002 - ESTOQUE FILIAIS      | 127191,501640 | 101,701 | 200        |         |

    @FE
    Exemplos:
      | fluxo           | itens  | filiais | statusCode | message                           |
      | FILIAL INVALIDA | 127191 | 1001    | 400        | Nenhuma filial informada é válida |
