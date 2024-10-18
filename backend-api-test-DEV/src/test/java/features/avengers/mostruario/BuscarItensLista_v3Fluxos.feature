#language: pt
@mostruario-service
Funcionalidade: Busca de lista de itens - v3

  Esquema do Cenario: Busca de lista de itens - v3 - Validacao <fluxo>
    Dado possuo dados para Mostruario - v3 - PostLista:
      | filial   | cep   | perfil   | codConvenio   |
      | <filial> | <cep> | <perfil> | <codConvenio> |
    Dado possuo dados para Mostruario - v3 - PostLista convenios:
      | codigoConvenio | matricula | codigoDependente |
      | 0              | string    | 0                |
    Dado possuo dados para Mostruario - v3 - PostLista itens:
      | codigo | quantidade | isPack |
      | 27     | 0          | false  |
      | 27     | 0          | false  |
    Dado possuo dados para Mostruario - v3 - PostLista consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | SP        | BR          |
    Quando executo Mostruario - v3 - PostLista
    Entao sistema processa Mostruario - v3 - PostLista:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FA
    Exemplos:
      | fluxo                   | filial | cep    | perfil | codConvenio | statusCode | field | message |
      | FA001 - sem filial      |        | string | 2      | 0           | 200        |       |         |
      | FA002 - sem cep         | 101    |        | 2      | 0           | 200        |       |         |
      | FA003 - sem codConvenio | 101    | string | 2      |             | 200        |       |         |
    @FE
    Exemplos:
      | fluxo          | filial | cep    | perfil | codConvenio | statusCode | field  | message                |
      | FE001 - perfil | 101    | string |        | 0           | 400        | perfil | O perfil é obrigatório |


  Esquema do Cenario: Busca de lista de itens - v3 - Valicacao Convenios <fluxo>
    Dado possuo dados para Mostruario - v3 - PostLista:
      | filial | cep    | perfil | codConvenio |
      | 101    | string | 2      | 0           |
    Dado possuo dados para Mostruario - v3 - PostLista convenios:
      | codigoConvenio   | matricula   | codigoDependente   |
      | <codigoConvenio> | <matricula> | <codigoDependente> |
    Dado possuo dados para Mostruario - v3 - PostLista itens:
      | codigo | quantidade | isPack |
      | 27     | 0          | false  |
      | 27     | 0          | false  |
    Dado possuo dados para Mostruario - v3 - PostLista consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | SP        | BR          |
    Quando executo Mostruario - v3 - PostLista
    Entao sistema processa Mostruario - v3 - PostLista:
      | statusCode | 200 |

    @FA
    Exemplos:
      | fluxo                        | codigoConvenio | matricula | codigoDependente |
      | FA004 - sem codigoConvenio   |                | string    | 0                |
      | FA005 - sem matricula        | 0              |           | 0                |
      | FA006 - sem codigoDependente | 0              | string    |                  |


  Esquema do Cenario: Busca de lista de itens - v3 - Valicacao Itens <fluxo>
    Dado possuo dados para Mostruario - v3 - PostLista:
      | filial | cep    | perfil | codConvenio |
      | 101    | string | 2      | 0           |
    Dado possuo dados para Mostruario - v3 - PostLista convenios:
      | codigoConvenio | matricula | codigoDependente |
      | 0              | string    | 0                |
    Dado possuo dados para Mostruario - v3 - PostLista itens:
      | codigo   | quantidade   | isPack   |
      | <codigo> | <quantidade> | <isPack> |
    Dado possuo dados para Mostruario - v3 - PostLista consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | SP        | BR          |
    Quando executo Mostruario - v3 - PostLista
    Entao sistema processa Mostruario - v3 - PostLista:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FA
    Exemplos:
      | fluxo                  | codigo | quantidade | isPack | statusCode | field | message |
      | FA007 - sem quantidade | 27     |            | false  | 200        |       |         |
      | FA008 - sem isPack     | 27     | 0          |        | 200        |       |         |
    @FE
    Exemplos:
      | fluxo               | codigo | quantidade | isPack | statusCode | field  | message               |
      | FE002 -  sem codigo |        | 0          | false  | 400        | codigo | codigo é obrigatório. |


  Esquema do Cenario: Busca de lista de itens - v3 - Valicacao ConsultaRegrasFiscais <fluxo>
    Dado possuo dados para Mostruario - v3 - PostLista:
      | filial | cep    | perfil | codConvenio |
      | 101    | string | 2      | 0           |
    Dado possuo dados para Mostruario - v3 - PostLista convenios:
      | codigoConvenio | matricula | codigoDependente |
      | 0              | string    | 0                |
    Dado possuo dados para Mostruario - v3 - PostLista itens:
      | codigo | quantidade | isPack |
      | 27     | 0          | false  |
      | 27     | 0          | false  |
    Dado possuo dados para Mostruario - v3 - PostLista consultaRegrasFiscais:
      | uf   | pais   | ufDestino   | paisDestino   |
      | <uf> | <pais> | <ufDestino> | <paisDestino> |
    Quando executo Mostruario - v3 - PostLista
    Entao sistema processa Mostruario - v3 - PostLista:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FE
    Exemplos:
      | fluxo                   | uf | pais | ufDestino | paisDestino | statusCode | field       | message                                                         |
      | FE009 - sem uf          |    | BR   | SP        | BR          | 400        | uf          | Para consulta de regras fiscais a UF é obrigatória              |
      | FE010 - sem pais        | RS |      | SP        | BR          | 400        | pais        | Para consulta de regras fiscais o país é obrigatório            |
      | FE011 - sem ufDestino   | RS | BR   |           | BR          | 400        | ufDestino   | Para consulta de regras fiscais a UF de destino é obrigatória   |
      | FE012 - sem paisDestino | RS | BR   | SP        |             | 400        | paisDestino | Para consulta de regras fiscais o país de destino é obrigatório |

