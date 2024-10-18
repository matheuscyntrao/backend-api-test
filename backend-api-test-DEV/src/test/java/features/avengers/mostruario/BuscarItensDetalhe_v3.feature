#language: pt
@mostruario-service @monteiro
Funcionalidade: Busca detalhes de itens - v3

  @FB @regressao
  Cenario: Busca de detalhes de itens - v3 - FB
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil | filial | cep      |
      | 2      | 31     | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo | isPack | quantidade |
      | 402732   | false  | 1          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | categoria&filter=advertencias&filter=alternativos&filter=videos&filter=participa-novo-pack&filter=preco-base&filter=bula&filter=categorias&filter=dados-imagem&filter=possui-ean-impresso&filter=preco-final&filter=principio-ativo&filter=promocao&filter=descontos&filter=regras-fiscais&filter=possui-genericos&filter=possui-iav&filter=lancamento&filter=desconto-pack&filter=desconto-pbm&filter=restricoes&filter=gera-dados-fornecedor&filter=multiatendimento&filter=convenio&filter=ean&filter=possui-similares&filter=bloqueados-internet&filter=descricao-detalhada&filter=venda-liberada&filter=codigo-fabricante&filter=tipo-item&filter=psicotropico&filter=nomenclatura&filter=retencao-receita&filter=possui-genericos&filter=otc&filter=custo-medio&filter=marca-pai&filter=uso-continuo&filter=cupom-oferta&filter=situacao-item&filter=classe-terapeutica&filter=adesao&filter=exclusivo-panvel&filter=item-geladeira&filter=participa-lista-referencial&filter=participa-farmacia-popular&filter=item-assinavel&filter=promocao-assinatura&filter=desconto-iav&filter=quantidade-apresentacao&filter=participa-pbm&filter=preco-unitizavel&filter=rentabilidade&filter=eans-alternativos&filter=presenteavel&filter=default |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |

  @FA @regressao
  Cenario: Busca de detalhes de itens - v3 - FA
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil | filial | cep      |
      | 2      | 31     | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo | isPack | quantidade |
      | 2855   | false  | 1          |
      | 499250 | false  | 1          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |


  Esquema do Cenario: Busca de detalhes de itens - v3 - PostItensDetalhe <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil   | filial   | cep   |
      | <perfil> | <filial> | <cep> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo | isPack | quantidade |
      | 2855   | false  | 1          |
      | 499250 | false  | 1          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | categoria&filter=advertencias&filter=alternativos&filter=videos&filter=participa-novo-pack&filter=preco-base&filter=bula&filter=categorias&filter=dados-imagem&filter=possui-ean-impresso&filter=preco-final&filter=principio-ativo&filter=promocao&filter=descontos&filter=regras-fiscais&filter=possui-genericos&filter=possui-iav&filter=lancamento&filter=desconto-pack&filter=desconto-pbm&filter=restricoes&filter=gera-dados-fornecedor&filter=multiatendimento&filter=convenio&filter=ean&filter=possui-similares&filter=bloqueados-internet&filter=descricao-detalhada&filter=venda-liberada&filter=codigo-fabricante&filter=tipo-item&filter=psicotropico&filter=nomenclatura&filter=retencao-receita&filter=possui-genericos&filter=otc&filter=custo-medio&filter=marca-pai&filter=uso-continuo&filter=cupom-oferta&filter=situacao-item&filter=classe-terapeutica&filter=adesao&filter=exclusivo-panvel&filter=item-geladeira&filter=participa-lista-referencial&filter=participa-farmacia-popular&filter=item-assinavel&filter=promocao-assinatura&filter=desconto-iav&filter=quantidade-apresentacao&filter=participa-pbm&filter=preco-unitizavel&filter=rentabilidade&filter=eans-alternativos&filter=presenteavel&filter=default |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FA @regressao
    Exemplos:
      | fluxo              | perfil | filial | cep      | statusCode | field | message |
      | FA002 - sem filial | 2      |        | 90620130 | 200        |       |         |
      | FA003 - sem cep    | 2      | 31     |          | 200        |       |         |
    @FE @regressao
    Exemplos:
      | fluxo              | perfil | filial | cep      | statusCode | field  | message                |
      | FE001 - sem perfil |        | 31     | 90620130 | 400        | perfil | O perfil é obrigatório |


  Esquema do Cenario: Busca de detalhes de itens - v3 - PostItensDetalhe-itens <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil | filial | cep      |
      | 2      | 31     | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo   | isPack   | quantidade   |
      | <codigo> | <isPack> | <quantidade> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | RS        | BR          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | categoria&filter=advertencias&filter=alternativos&filter=videos&filter=participa-novo-pack&filter=preco-base&filter=bula&filter=categorias&filter=dados-imagem&filter=possui-ean-impresso&filter=preco-final&filter=principio-ativo&filter=promocao&filter=descontos&filter=regras-fiscais&filter=possui-genericos&filter=possui-iav&filter=lancamento&filter=desconto-pack&filter=desconto-pbm&filter=restricoes&filter=gera-dados-fornecedor&filter=multiatendimento&filter=convenio&filter=ean&filter=possui-similares&filter=bloqueados-internet&filter=descricao-detalhada&filter=venda-liberada&filter=codigo-fabricante&filter=tipo-item&filter=psicotropico&filter=nomenclatura&filter=retencao-receita&filter=possui-genericos&filter=otc&filter=custo-medio&filter=marca-pai&filter=uso-continuo&filter=cupom-oferta&filter=situacao-item&filter=classe-terapeutica&filter=adesao&filter=exclusivo-panvel&filter=item-geladeira&filter=participa-lista-referencial&filter=participa-farmacia-popular&filter=item-assinavel&filter=promocao-assinatura&filter=desconto-iav&filter=quantidade-apresentacao&filter=participa-pbm&filter=preco-unitizavel&filter=rentabilidade&filter=eans-alternativos&filter=presenteavel&filter=default |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FA @regressao
    Exemplos:
      | fluxo                  | codigo | isPack | quantidade | statusCode | field | message |
      | FA004 - sem quantidade | 2855   | false  |            | 200        |       |         |
    @FE @regressao
    Exemplos:
      | fluxo              | codigo | isPack | quantidade | statusCode | field  | message               |
      | FE002 - sem codigo |        | false  | 1          | 400        | codigo | codigo é obrigatório. |


  Esquema do Cenario: Busca de detalhes de itens - v3 - PostItensDetalhe-consultaRegrasFiscais <fluxo>
    Dado possuo dados para Mostruario - v3 - PostItensDetalhe:
      | perfil | filial | cep      |
      | 2      | 31     | 90620130 |
    E possuo dados para Mostruario - v3 - PostItensDetalhe itens:
      | codigo | isPack | quantidade |
      | 2855   | false  | 1          |
      | 499250 | false  | 1          |
    E possuo dados para Mostruario - v3 - PostItensDetalhe consultaRegrasFiscais:
      | uf   | pais   | ufDestino   | paisDestino   |
      | <uf> | <pais> | <ufDestino> | <paisDestino> |
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | categoria&filter=advertencias&filter=alternativos&filter=videos&filter=participa-novo-pack&filter=preco-base&filter=bula&filter=categorias&filter=dados-imagem&filter=possui-ean-impresso&filter=preco-final&filter=principio-ativo&filter=promocao&filter=descontos&filter=regras-fiscais&filter=possui-genericos&filter=possui-iav&filter=lancamento&filter=desconto-pack&filter=desconto-pbm&filter=restricoes&filter=gera-dados-fornecedor&filter=multiatendimento&filter=convenio&filter=ean&filter=possui-similares&filter=bloqueados-internet&filter=descricao-detalhada&filter=venda-liberada&filter=codigo-fabricante&filter=tipo-item&filter=psicotropico&filter=nomenclatura&filter=retencao-receita&filter=possui-genericos&filter=otc&filter=custo-medio&filter=marca-pai&filter=uso-continuo&filter=cupom-oferta&filter=situacao-item&filter=classe-terapeutica&filter=adesao&filter=exclusivo-panvel&filter=item-geladeira&filter=participa-lista-referencial&filter=participa-farmacia-popular&filter=item-assinavel&filter=promocao-assinatura&filter=desconto-iav&filter=quantidade-apresentacao&filter=participa-pbm&filter=preco-unitizavel&filter=rentabilidade&filter=eans-alternativos&filter=presenteavel&filter=default |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FE @regressao
    Exemplos:
      | fluxo                   | uf | pais | ufDestino | paisDestino | statusCode | field       | message                                                         |
      | FE003 - sem uf          |    | BR   | RS        | BR          | 400        | uf          | Para consulta de regras fiscais a UF é obrigatória              |
      | FE004 - sem pais        | RS |      | RS        | BR          | 400        | pais        | Para consulta de regras fiscais o país é obrigatório            |
      | FE005 - sem ufDestino   | RS | BR   |           | BR          | 400        | ufDestino   | Para consulta de regras fiscais a UF de destino é obrigatória   |
      | FE006 - sem paisDestino | RS | BR   | RS        |             | 400        | paisDestino | Para consulta de regras fiscais o país de destino é obrigatório |
