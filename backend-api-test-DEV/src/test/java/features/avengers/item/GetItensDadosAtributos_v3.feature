#language: pt
@item-service @cupom2.0 @cupom2.0_sp1
Funcionalidade: Get Itens Atributo - v3

  Esquema do Cenario: Get Itens Atributo - v3 <fluxo>
    Dado possuo dados para Item - v3 - GetItensDadosAtributos
    Quando executo Item - v3 - GetItensDadosAtributos
    Entao sistema processa Item - v3 - GetItensDadosAtributos
      | statusCode | <statusCode> |
    E valido Item - v3 - GetItensDadosAtributos:
      | valorAtributo      |
      | Item               |
      | Fornecedor         |
      | Tipo               |
      | Grupo              |
      | Subgrupo           |
      | Subcategoria       |
      | Categoria          |
      | Submarca           |
      | Marca              |
      | Classe Terapêutica |
      | Princípio Ativo    |
      | Otc                |
      | Psico              |
      | Avulso             |
      | Relação            |
      | Tarja              |
      | Uso Contínuo       |
      | Agrupamento        |
      | Embalagem          |
      | Volume             |
      | Tamanho            |
      | Classificação      |
      | Textura            |
      | Voltagem           |
      | Cor                |
      | Gênero             |
      | Fps                |
      | Tonalidade         |
      | Tipo de Pele       |
      | Especialidade      |
      | Sabor              |
      | Segmentação        |
      | Formato            |

    @FB @regressao
    Exemplos:
      | fluxo | statusCode |
      | FB    | 200        |
