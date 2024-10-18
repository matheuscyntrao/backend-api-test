#language: pt
@mostruario-service @monteiro
Funcionalidade: Busca detalhes de itens - v3

  Esquema do Cenario: Busca de detalhes de itens - v3 - Mudanca de filtros <fluxo>
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
    E possuo dados para Mostruario - v3 - PostItensDetalhe param:
      | filter | <filter> |
    Quando executo Mostruario - v3 - PostItensDetalhe
    Entao sistema processa Mostruario - v3 - PostItensDetalhe:
      | statusCode | 200 |
    E valido Mostruario - v3 - PostItensDetalhe campo "<campo>"

    @FA @regressao
    Exemplos:
      | fluxo                               | filter                      | campo        |
      | FA005 - categoria                   | categoria                   |              |
      | FA006 - advertencias                | advertencias                | advertencias |
      | FA007 - alternativos                | alternativos                |              |
      | FA008 - videos                      | videos                      |              |
      | FA009 - participa-novo-pack         | participa-novo-pack         |              |
      | FA010 - preco-base                  | preco-base                  |              |
      | FA011 - bula                        | bula                        |              |
      | FA012 - categorias                  | categorias                  | categorias   |
      | FA013 - dados-imagem                | dados-imagem                |              |
      | FA014 - possui-ean-impresso         | possui-ean-impresso         |              |
      | FA015 - preco-final                 | preco-final                 |              |
      | FA016 - principio-ativo             | principio-ativo             |              |
      | FA017 - promocao                    | promocao                    |              |
      | FA018 - descontos                   | descontos                   | descontos    |
      | FA019 - regras-fiscais              | regras-fiscais              |              |
      | FA020 - possui-genericos            | possui-genericos            |              |
      | FA021 - possui-iav                  | possui-iav                  |              |
      | FA022 - lancamento                  | lancamento                  | lancamento   |
      | FA023 - desconto-pack               | desconto-pack               |              |
      | FA024 - desconto-pbm                | desconto-pbm                |              |
      | FA025 - restricoes                  | restricoes                  | restricoes   |
      | FA026 - gera-dados-fornecedor       | gera-dados-fornecedor       |              |
      | FA027 - multiatendimento            | multiatendimento            |              |
      | FA028 - convenio                    | convenio                    |              |
      | FA029 - ean                         | ean                         | ean          |
      | FA030 - possui-similares            | possui-similares            |              |
      | FA031 - bloqueados-internet         | bloqueados-internet         |              |
      | FA032 - descricao-detalhada         | descricao-detalhada         |              |
      | FA033 - venda-liberada              | venda-liberada              |              |
      | FA034 - codigo-fabricante           | codigo-fabricante           |              |
      | FA035 - tipo-item                   | tipo-item                   |              |
      | FA036 - psicotropico                | psicotropico                | psicotropico |
      | FA037 - nomenclatura                | nomenclatura                | nomenclatura |
      | FA038 - retencao-receita            | retencao-receita            |              |
      | FA039 - possui-genericos            | possui-genericos            |              |
      | FA040 - otc                         | otc                         |              |
      | FA041 - custo-medio                 | custo-medio                 |              |
      | FA042 - marca-pai                   | marca-pai                   |              |
      | FA043 - uso-continuo                | uso-continuo                |              |
      | FA044 - cupom-oferta                | cupom-oferta                |              |
      | FA045 - situacao-item               | situacao-item               |              |
      | FA046 - classe-terapeutica          | classe-terapeutica          |              |
      | FA047 - adesao                      | adesao                      |              |
      | FA048 - exclusivo-panvel            | exclusivo-panvel            |              |
      | FA049 - item-geladeira              | item-geladeira              |              |
      | FA050 - participa-lista-referencial | participa-lista-referencial |              |
      | FA051 - participa-farmacia-popular  | participa-farmacia-popular  |              |
      | FA052 - item-assinavel              | item-assinavel              |              |
      | FA053 - promocao-assinatura         | promocao-assinatura         |              |
      | FA054 - desconto-iav                | desconto-iav                |              |
      | FA055 - quantidade-apresentacao     | quantidade-apresentacao     |              |
      | FA056 - participa-pbm               | participa-pbm               |              |
      | FA057 - preco-unitizavel            | preco-unitizavel            |              |
      | FA058 - rentabilidade               | rentabilidade               |              |
      | FA059 - eans-alternativos           | eans-alternativos           |              |
      | FA060 - presenteavel                | presenteavel                | presenteavel |
      | FA061 - default                     | default                     |              |
