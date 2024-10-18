#language: pt
@item-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: Bff Itens - v1

  Esquema do Cenario: Bff Itens - v1 <fluxo>
    Dado possuo dados para Bff Item - v1 - GetItensAtributos:
      | atributo | <atributo> |
    Quando executo Bff Item - v1 - GetItensAtributos
    Entao sistema processa Bff Item - v1 - GetItensAtributos:
      | statusCode | <statusCode> |
    E valido Bff Item - v1 - GetItensAtributos:
      | nomeAtributo |
      | <item1>      |
      | <item2>      |
      | <item3>      |
    E valido Bff Item - v1 - GetItensAtributos mensagem de erro "<mensagem>"


    @FB @regressao
    Exemplos:
      | fluxo | atributo | statusCode | item1  | item2 | item3 | mensagem |
      | FB    | VOLTAGEM | 200        | BIVOLT | 220 V | 110 V |          |
    @FE @regressao
    Exemplos:
      | fluxo                 | atributo  | statusCode | item1 | item2 | item3 | mensagem                                               |
#      | FE001 - Não existente | TIPO_PELE | 200        |       |       |       |                                                        |
      | FE002 - Não existente | ZMUDA     | 400        |       |       |       | Item informado não é válido!                           |


  Esquema do Cenario: Get Bff Item - v1 - Todos <fluxo>
    Dado possuo dados para Bff Item - v1 - GetItensAtributos:
      | atributo | <atributo> |
    Quando executo Bff Item - v1 - GetItensAtributos
    E valido Bff Item - v1 - GetItensAtributos "<atributo>"

    @FA @regressao
    Exemplos:
      | fluxo                           | atributo                |
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
      | FA030 - ESPECIALIDADE           | ESPECIALIDADE           |
      | FA031 - SABOR                   | SABOR                   |
      | FA032 - SEGMENTACAO             | SEGMENTACAO             |
      | FA033 - FORMATO                 | FORMATO                 |

