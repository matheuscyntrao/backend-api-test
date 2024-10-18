#language: pt
@mostruario-service @monteiro
Funcionalidade: Busca detalhes de itens - v3

  Esquema do Cenario: Busca de detalhes de itens - v3 - Mudanca de filtros squina <fluxo>
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
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |

    @FA @regressao
    Exemplos:
      | fluxo                      | filter  | codigo | isPack | quantidade | filial | perfil | codigoCupomOfertas |
      | Squina - Pack              | default | 499250 | false  | 3          | 101    | 1      |                    |
      | Squina - PBM               | default | 468870 | false  | 3          | 101    | 1      |                    |
      | Squina - retem receita     | default | 883900 | false  | 3          | 101    | 1      |                    |
      | Squina - similares         | default | 844980 | false  | 3          | 101    | 1      |                    |
      | Squina - desconto          | default | 476610 | false  | 3          | 101    | 1      |                    |
      | Squina - desconto de promo | default | 115482 | false  | 3          | 101    | 1      |                    |
      | Squina - cupom de oferta   | default | 115482 | false  | 3          | 101    | 1      |                    |


  Esquema do Cenario: Busca de detalhes de itens - v3 - Mudanca de filtros squina convenio <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil   | filial   | cep      |
      | <perfil> | <filial> | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo   | isPack   | quantidade   |
      | <codigo> | <isPack> | <quantidade> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe convenio:
      | codigoConvenio   | matricula   | codigoDependente   |
      | <codigoConvenio> | <matricula> | <codigoDependente> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | <filter> |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |

    @FA @regressao
    Exemplos:
      | fluxo             | filter  | codigo | isPack | quantidade | filial | perfil | codigoConvenio | matricula | codigoDependente |
      | Squina - desconto | default | 476610 | false  | 3          | 101    | 1      | 412104         | null      | null             |
