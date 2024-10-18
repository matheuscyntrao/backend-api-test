#language: pt
@mostruario-service
Funcionalidade: Busca por Principio Ativo - v3

  Esquema do Cenario: Busca de produtos por principio ativo - v3 <fluxo>
    Dado possuo dados para Mostruario - v3 - GetPrincipioAtivo path :
      | item | <item> |
    E possuo dados para Mostruario - v3 - GetPrincipioAtivo param :
      | filial         | <filial>         |
      | perfil         | <perfil>         |
      | principioAtivo | <principioAtivo> |
      | categoria      | <categoria>      |
    Quando executo Mostruario - v3 - GetPrincipioAtivo
    Entao sistema processa Mostruario - v3 - GetPrincipioAtivo:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | item   | filial | perfil | principioAtivo | categoria | statusCode | field | message |
      | FB    | 461640 | 101    | 1      | 47             | S         | 200        |       |         |
    @FE @regressao
    Exemplos:
      | fluxo                      | item   | filial | perfil | principioAtivo | categoria | statusCode | field          | message                           |
      | FE001 - sem item           |        | 101    | 1      | 47             | S         | 404        |                |                                   |
      | FE002 - sem filial         | 461640 |        | 1      | 47             | S         | 400        |                | É necessário enviar cep ou filial |
      | FE003 - sem perfil         | 461640 | 101    |        | 47             | S         | 400        |                | Perfil de venda é obrigatório     |
      | FE004 - sem principioAtivo | 461640 | 101    | 1      |                | S         | 400        | principioAtivo | may not be null                   |
      | FE005 - sem categoria      | 461640 | 101    | 1      | 47             |           | 400        | categoria      | may not be null                   |
