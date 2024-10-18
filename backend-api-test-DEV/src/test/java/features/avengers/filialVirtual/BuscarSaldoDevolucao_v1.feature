#language: pt
@filial-virtual-service
Funcionalidade: Buscar saldo para devolucao - v1

  Esquema do Cenario: Busca saldo para devolucao - v1 <fluxo>
    Dado possuo dados para FilialVirtual - v1 - GetSaldoDevolucao path:
      | filial | <filial> |
    Dado possuo dados para FilialVirtual - v1 - GetSaldoDevolucao param:
      | cpf | <cpf> |
    Quando executo FilialVirtual - v1 - GetSaldoDevolucao
    Entao sistema processa FilialVirtual - v1 - GetSaldoDevolucao:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FE @regressao
    Exemplos:
      | fluxo | filial | cpf         | statusCode | message                  |
      | FE    | 101    | 18436510097 | 404        | não há saldo disponível. |
