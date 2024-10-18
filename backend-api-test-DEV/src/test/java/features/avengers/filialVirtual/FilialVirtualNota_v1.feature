#language: pt
@filial-virtual-service
Funcionalidade: Filial Virtual Nota - v1

  Esquema do Cenario: Filial Virtual Nota - v1 <fluxo>
    Dado possuo dados para FilialVirtual - v1 - PostNota:
      | codigoFilial   | codigoAtendente   | codigoFuncionario   | codigoUsuario   | numeroPedido   | imprimeNfe   |
      | <codigoFilial> | <codigoAtendente> | <codigoFuncionario> | <codigoUsuario> | <numeroPedido> | <imprimeNfe> |
    Quando executo FilialVirtual - v1 - PostNota
    Entao sistema processa FilialVirtual - v1 - PostNota:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FE @regressao
    Exemplos:
      | fluxo                         | codigoFilial | codigoAtendente | codigoFuncionario | codigoUsuario | numeroPedido | imprimeNfe | statusCode | field             | message                             |
      | FE001 - sem codigoFilial      |              | 3700            | 27423             | 3700          | 18869513     | false      | 400        | codigoFilial      | Código da filial é necessário.      |
      | FE002 - sem codigoAtendente   | 101          |                 | 27423             | 3700          | 18869513     | false      | 400        | codigoAtendente   | Código do atendente é necessário.   |
      | FE003 - sem codigoFuncionario | 101          | 3700            |                   | 3700          | 18869513     | false      | 400        | codigoFuncionario | Código do funcionário é necessário. |
      | FE004 - sem codigoUsuario     | 101          | 3700            | 27423             |               | 18869513     | false      | 400        | codigoUsuario     | Código do usuário é necessário.     |
      | FE005 - sem  numeroPedido     | 101          | 3700            | 27423             | 3700          |              | false      | 400        | numeroPedido      | Número do pedido é necessário.      |

