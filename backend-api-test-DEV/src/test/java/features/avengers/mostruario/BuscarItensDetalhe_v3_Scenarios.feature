#language: pt
@mostruario-service @monteiro
Funcionalidade: Busca detalhes de itens - v3

  Esquema do Cenario: Busca de detalhes de itens - v3 - Mudanca de filtros scenarios <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil   | filial   | cep      |
      | <perfil> | <filial> | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo    | isPack    | quantidade |
      | <codigo>  | <isPack>  | 1          |
      | <codigo2> | <isPack2> | 1          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe convenio:
      | codigoConvenio   | matricula   |
      | <codigoConvenio> | <matricula> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | <filter> |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |

    @FA @regressao
    Exemplos:
      | fluxo             | filter  | codigo | isPack | filial | perfil | codigo2 | isPack2 | codigoConvenio | matricula |
      | Squina - Convenio | default | 568040 | false  | 31     | 2      | 568040  | false   |                |           |
      | Squina - Packs    | default | 117674 | true   | 31     | 2      | 117674  | false    | 416061         |           |


  Esquema do Cenario: Busca de detalhes de itens - v3 - Mudanca de filtros scenarios <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil   | filial   | cep      | codigoCupomOfertas   |
      | <perfil> | <filial> | 90620130 | <codigoCupomOfertas> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo   | isPack   | quantidade   |
      | <codigo> | <isPack> | <quantidade> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | <filter> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe convenio:
      | codigoConvenio   | matricula   | codigoDependente   |
      | <codigoConvenio> | <matricula> | <codigoDependente> |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |



    @FA @regressao
    Exemplos:
      | fluxo            | filter  | codigo | isPack | quantidade | filial | perfil | codigoCupomOfertas | codigoConvenio | matricula   | codigoDependente |
      | Scenario - Cupom | default | 116301 | false  | 1          | 053    | 1      | 24496143           | 416061         | 53070550053 | null             |


