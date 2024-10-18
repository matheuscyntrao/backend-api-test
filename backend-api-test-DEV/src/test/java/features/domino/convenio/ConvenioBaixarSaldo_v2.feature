#language: pt
@convenio-service
Funcionalidade: Baixa de Saldo de Convenio - v2

  Esquema do Cenario: Baixa de Saldo de Convenio - v2 - <fluxo>
    Dado possuo dados para Convenio - v2 - PutBaixarSaldo:
      | filial   | filialConvenio   | convenio   | associado   | matricula   | valorVenda   | tipoTransacao   |
      | <filial> | <filialConvenio> | <convenio> | <associado> | <matricula> | <valorVenda> | <tipoTransacao> |
    Quando executo Convenio - v2 - PutBaixarSaldo
    Entao sistema processa Convenio - v2 - PutBaixarSaldo:
      | statusCode | <statusCode> |
      | field      | <field>      |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo | filial | filialConvenio | convenio | associado | matricula | valorVenda | tipoTransacao | statusCode | field | message |
      #| FB | 101    | 1002           | 450057   | 7557773   | 1589724001 | 657        | C             | 200        |       |         |    TODO:Timeout

    @FE @regressao
    Exemplos:
      | fluxo                      | filial | filialConvenio | convenio | associado | matricula  | valorVenda | tipoTransacao | statusCode | field          | message                        |
      | FE001 - sem filial         |        | 1002           | 450057   | 7557773   | 1589724001 | 657        | C             | 400        | filial         | may not be null                |
      | FE002 - sem filialConvenio | 101    |                | 450057   | 7557773   | 1589724001 | 657        | C             | 400        | filialConvenio | may not be null                |
      | FE003 - sem convenio       | 101    | 1002           |          | 7557773   | 1589724001 | 657        | C             | 400        | convenio       | may not be null                |
      | FE004 - sem associado      | 101    | 1002           | 450057   |           | 1589724001 | 657        | C             | 400        | associado      | Campo associado é obrigatório. |
      | FE005 - sem matricula      | 101    | 1002           | 450057   | 7557773   |            | 657        | C             | 400        | matricula      | Campo matricula é obrigatório. |
      | FE006 - sem valorVenda     | 101    | 1002           | 450057   | 7557773   | 1589724001 |            | C             | 400        | valorVenda     | may not be null                |
      | FE007 - sem tipoTransacao  | 101    | 1002           | 450057   | 7557773   | 1589724001 | 657        |               | 400        | tipoTransacao  | may not be null                |