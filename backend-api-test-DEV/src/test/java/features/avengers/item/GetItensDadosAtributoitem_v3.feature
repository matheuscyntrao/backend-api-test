#language: pt
@item-service @cupom2.0 @cupom2.0_sp1
Funcionalidade: Get Itens Dado Item - v3

  Esquema do Cenario: Get Itens Dado Item - v3 FB <fluxo>
    Dado possuo dados para Item - v3 - GetItensDadosAtributoitem:
      | atributoItem | <atributoItem> |
    Quando executo Item - v3 - GetItensDadosAtributoitem
    Entao sistema processa Item - v3 - GetItensDadosAtributoitem
      | statusCode | <statusCode> |
    E valido Item - v3 - GetItensDadosAtributoitem:
      | nomeAtributo |
      | <item1>      |
      | <item2>      |
      | <item3>      |
    E valido Item - v3 - GetItensDadosAtributoitem mensagem de erro "<mensagem>"


    @FB @regressao
    Exemplos:
      | fluxo        | atributoItem | statusCode | item1   | item2    | item3     | mensagem |
      | FB           | VOLTAGEM     | 200        | BIVOLT  | 220 V    | 110 V     |          |
      | FA001-genero | GENERO       | 200        | UNISSEX | FEMININO | MASCULINO |          |
    @FE @regressao
    Exemplos:
      | fluxo                 | atributoItem | statusCode | item1 | item2 | item3 | mensagem                     |
      | FE001 - Não existente | ZMUDA        | 400        |       |       |       | Item informado não é válido! |


  Esquema do Cenario: Get Itens Dado Item - v3 - Todos <fluxo>
    Dado possuo dados para Item - v3 - GetItensDadosAtributoitem:
      | atributoItem | <atributoItem> |
    Quando executo Item - v3 - GetItensDadosAtributoitem
    E valido Item - v3 - GetItensDadosAtributoitem "<atributoItem>"

    @FA @regressao
    Exemplos:
      | fluxo                           | atributoItem            |
      | FA001 - ITEM                    | ITEM                    |
      | FA002 - FORNECEDOR              | FORNECEDOR              |
      | FA003 - TIPO                    | TIPO                    |
      | FA004 - GRUPO                   | GRUPO                   |
      | FA005 - SUBGRUPO                | SUBGRUPO                |
      | FA006 - SUBCATEGORIA            | SUBCATEGORIA            |
      | FA007 - CATEGORIA               | CATEGORIA               |
      | FA008 - SUBMARCA                | SUBMARCA                |
      | FA009 - MARCA                   | MARCA                   |
      | FA010 - CLASSE_TERAPEUTICA      | CLASSE_TERAPEUTICA      |
      | FA011 - PRINCIPIO_ATIVO         | PRINCIPIO_ATIVO         |
      | FA012 - OTC                     | OTC                     |
      | FA013 - PSICOTROPICO            | PSICOTROPICO            |
      | FA014 - AVULSO                  | AVULSO                  |
      | FA015 - RELACAO                 | RELACAO                 |
      | FA016 - TARJA                   | TARJA                   |
      | FA017 - USO_CONTINUO            | USO_CONTINUO            |
      | FA018 - AGRUPAMENTO             | AGRUPAMENTO             |
      | FA019 - APRESENTACAO_EMBALAGEM  | APRESENTACAO_EMBALAGEM  |
      | FA020 - VOLUME                  | VOLUME                  |
      | FA021 - TAMANHO                 | TAMANHO                 |
      | FA022 - CLASSIFICACAO_INDICACAO | CLASSIFICACAO_INDICACAO |
      | FA023 - TEXTURA                 | TEXTURA                 |
      | FA024 - VOLTAGEM                | VOLTAGEM                |
      | FA025 - COR                     | COR                     |
      | FA026 - GENERO                  | GENERO                  |
      | FA027 - FPS                     | FPS                     |
      | FA028 - TONALIDADE              | TONALIDADE              |
      | FA029 - TIPO_PELE               | TIPO_PELE               |
      | FA030 - ESPECIALIDADE           | ESPECIALIDADE           |
      | FA031 - SABOR                   | SABOR                   |
      | FA032 - SEGMENTACAO             | SEGMENTACAO             |
      | FA033 - FORMATO                 | FORMATO                 |
