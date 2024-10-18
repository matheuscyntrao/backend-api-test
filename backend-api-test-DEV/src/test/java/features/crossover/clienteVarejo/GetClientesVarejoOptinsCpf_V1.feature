#language: pt
@cliente-varejo-service
Funcionalidade: ClienteVarejo-V1-GetClientesOptinCpf


  Esquema do Cenario: ClienteVarejo V1 GetClientesOptinCpf - <fluxo>
    Dado possuo dados para ClienteVarejo - V1 - GetClientesOptinCpf path:
      | cpf | <cpf> |
    Quando executo ClienteVarejo - V1 - GetClientesOptinCpf
    Entao sistema processa ClienteVarejo - V1 - GetClientesOptinCpf:
      | statusCode | <statusCode> |
    E valido "<message>" ClienteVarejo - V1 - GetClientesOptinCpf

    @FB @regressao
    Exemplos:
      | fluxo | cpf         | statusCode | message                                         |
      | FB    | 02140506022 | 200        |                                                 |
      | FB    | 0214050602  | 404        | Não foi possivel encontrar optin para este cpf. |

