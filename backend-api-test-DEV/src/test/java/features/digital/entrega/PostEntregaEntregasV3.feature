#language: pt
@entrega-service
Funcionalidade: Entrega - v3 - Entregas

  Esquema do Cenario: Entrega - v3 - Entregas - <fluxo>
    Dado que possuo dados para Entrega - v3 - Entregas:
      | filial   | cep   | dataConsulta   | perfil   | operacao   | codCliente   | codigoLogradouro   | numeroEndereco   | consultaCD   | origemDesvioEstoque   | logistica   |
      | <filial> | <cep> | <dataConsulta> | <perfil> | <operacao> | <codCliente> | <codigoLogradouro> | <numeroEndereco> | <consultaCD> | <origemDesvioEstoque> | <logistica> |
    Dado que possuo dados para Entrega - v3 - Entregas itens:
      | codigo   | quantidade | quantidadeEntregar | isPack |
      | <codigo> | 1          | 1                  | false  |
    Quando executo Entrega - v3 - Entregas
    Entao sistema processa Entrega - v3 - Entregas:
      | statusCode | <statusCode> |
    E valido Entrega - v3 - Entregas "<tipoDeEntrega>"


    @FB @regressao
    Exemplos:
      | fluxo | filial | cep      | dataConsulta             | perfil | operacao | codCliente | codigoLogradouro | numeroEndereco | consultaCD | origemDesvioEstoque | logistica | codigo | statusCode | tipoDeEntrega |
      | FB    |        | 99062260 | 2020-09-10T18:00:00.000Z | 2      | 826      |            |                  |                | false      |                     |           | 5657   | 200        | MOTOBOY,ROTAS |
      | FB    |        | 88053135 | 2020-09-10T18:00:00.000Z | 2      | 826      |            |                  |                | false      |                     |           | 501640 | 200        | MOTOBOY,ROTAS |
      | FB    |        | 90680050 | 2020-09-10T18:00:00.000Z | 2      | 826      |            |                  |                | false      |                     |           | 501640 | 200        | MOTOBOY,ROTAS |
