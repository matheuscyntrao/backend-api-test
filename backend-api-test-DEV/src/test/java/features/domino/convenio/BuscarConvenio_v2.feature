#language: pt
@convenio-service
Funcionalidade: Buscar Convenio - v2

  Esquema do Cenario: Busca Convenio - v2 <fluxo>
    Dado possuo dados para Convenio - v2 - GetConvenio param:
      | convenio   | <convenio>   |
      | filial     | <filial>     |
      | canalVenda | <canalVenda> |
    Quando executo Convenio - v2 - GetConvenio
    Entao sistema processa Convenio - v2 - GetConvenio:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | convenio | filial | canalVenda | statusCode | field | message |
      | FB    | cabergs  | 101    | 1          | 200        |       |         |
    @FA @regressao
    Exemplos:
      | fluxo                  | convenio | filial | canalVenda | statusCode | field | message |
      | FA001 - sem convenio   |          | 101    | 1          | 200        |       |         |
      | FA002 - sem canalVenda | cabergs  | 101    |            | 200        |       |         |
    @FE @regressao
    Exemplos:
      | fluxo              | convenio | filial | canalVenda | statusCode | field  | message                           |
      | FE001 - sem filial | cabergs  |        | 1          | 400        | filial | Filial do Convenio é obrigatória. |
