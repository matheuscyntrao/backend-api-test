#language: pt
@filial-service
Funcionalidade: Get Filial Cep - v1

  Esquema do Cenario: Get Filial Cep <fluxo>
    Dado possuo dados para Filial - v1 - GetFilialCep path:
      | cep | <cep> |
    Quando executo Filial - v1 - GetFilialCep
    Entao sistema processa Filial - v1 - GetFilialCep:
      | statusCode | <statusCode> |
    E valido Filial - v1 - GetFilialCep "<message>"

    @FB @regressao
    Exemplos:
      | fluxo                 | cep      | statusCode | message |
      | FB - BUSCA FILIAL CEP | 94030210 | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo                                  | cep      | statusCode | message                                            |
      | FE001 - CEP Invalido Numero            | 00000000 | 404        | Nenhuma filial disponível encontrada na localidade |
      | FE002 - CEP Invalido caracter especial | -0000000 | 404        | Nenhuma filial disponível encontrada na localidade |
      | FE003 - CEP Invalido Letra             | A0000000 | 404        | Nenhuma filial disponível encontrada na localidade |