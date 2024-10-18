#language: pt
@item-service @cupom2.0 @cupom2.0_sp2
Funcionalidade: OmniDashboard - v1

  Esquema do Cenario:  OmniDashboard - v1 <fluxo>
    Dado possuo dados para OmniDashboard - v1 - GetItens
    Quando executo OmniDashboard - v1 - GetItens
    Entao sistema processa OmniDashboard - v1 - GetItens
      | statusCode | <statusCode> |
    E valido OmniDashboard - v1 - GetItens:
      | attributeName           | attributeValue     |
      | ITEM                    | Item               |
      | FORNECEDOR              | Fornecedor         |
      | TIPO                    | Tipo               |
      | GRUPO                   | Grupo              |
      | SUBGRUPO                | Subgrupo           |
      | SUBCATEGORIA            | Subcategoria       |
      | CATEGORIA               | Categoria          |
      | SUBMARCA                | Submarca           |
      | MARCA                   | Marca              |
      | CLASSE_TERAPEUTICA      | Classe Terapêutica |
      | PRINCIPIO_ATIVO         | Princípio Ativo    |
      | OTC                     | Otc                |
      | PSICOTROPICO            | Psico              |
      | AVULSO                  | Avulso             |
      | RELACAO                 | Relação            |
      | TARJA                   | Tarja              |
      | USO_CONTINUO            | Uso Contínuo       |
      | AGRUPAMENTO             | Agrupamento        |
      | APRESENTACAO_EMBALAGEM  | Embalagem          |
      | VOLUME                  | Volume             |
      | TAMANHO                 | Tamanho            |
      | CLASSIFICACAO_INDICACAO | Classificação      |
      | TEXTURA                 | Textura            |
      | VOLTAGEM                | Voltagem           |
      | COR                     | Cor                |
      | GENERO                  | Gênero             |
      | FPS                     | Fps                |
      | TONALIDADE              | Tonalidade         |
      | TIPO_PELE               | Tipo de Pele       |
      | ESPECIALIDADE           | Especialidade      |
      | SABOR                   | Sabor              |
      | SEGMENTACAO             | Segmentação        |
      | FORMATO                 | Formato            |

    @FB @regressao
    Exemplos:
      | fluxo | statusCode |
      | FB    | 200        |
