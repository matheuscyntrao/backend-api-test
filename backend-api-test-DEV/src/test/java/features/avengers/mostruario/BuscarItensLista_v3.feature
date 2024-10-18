#language: pt
@mostruario-service
Funcionalidade: Busca de lista de itens - v3

  @FB
  Cenario: Busca de lista de itens - v3 - FB
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
      | uf | pais | ufDestino | paisDestino |
      | RS | BR   | SP        | BR          |
    Quando executo Mostruario - v3 - PostLista
    Entao sistema processa Mostruario - v3 - PostLista:
      | statusCode | 200 |