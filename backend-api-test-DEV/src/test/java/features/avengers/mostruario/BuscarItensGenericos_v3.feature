#language: pt
@mostruario-service
Funcionalidade: Busca por Genericos - v3

  Esquema do Cenario: Busca de produtos por genericos - v3 <fluxo>
    Dado possuo dados para Mostruario - v3 - GetGenericos path :
      | item | <item> |
    E possuo dados para Mostruario - v3 - GetGenericos param :
      | filial | <filial> |
      | perfil | <perfil> |
    Quando executo Mostruario - v3 - GetGenericos
    Entao sistema processa Mostruario - v3 - GetGenericos:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | item   | filial | perfil | statusCode | message |
      | FB    | 461640 | 101    | 1      | 200        |         |
    @FE @regressao
    Exemplos:
      | fluxo              | item   | filial | perfil | statusCode | message                           |
      | FE001 - sem item   |        | 101    | 1      | 404        |                                   |
      | FE001 - sem filial | 461640 |        | 1      | 400        | É necessário enviar cep ou filial |
      | FE001 - sem perfil | 461640 | 101    |        | 400        | Perfil de venda é obrigatório     |
