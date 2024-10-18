#language: pt
@bank-account-service @deleteAccount
Funcionalidade: BankAccountService - v1


  Esquema do Cenario:  BankAccountService - v1 <fluxo>
    Dado possuo dados para BankAccountService - v1 - BuscaCPFBankAccount:
      | cpf   |
      | <cpf> |
    E possuo dados para BankAccountService - v1 - GeraToken
    E possuo dados para BankAccountService - v1 - deleteAccountByCpf
    Quando executo BankAccountService - v1 - PostCreateAccount <criacaoConta>
    Entao sistema processa BankAccountService - v1 - CreateStatus:
      | statusCode | <statusCode> |
      | message    | <message>    |

    @FB @regressao
    Exemplos:
      | fluxo                        | cpf         | criacaoConta | statusCode | message                                            |
      | FB - Cadastro de Conta       | 00703592025 | 1            | 201        |                                                    |
      | FA - Cliente já possui Conta | 00703592025 | 2            | 409        | Já existe uma conta cadastrada com o cpf informado |
      | FA - CPF não Autorizado      | 15728537006 | 1            | 404        | Cliente Não Encontrado                             |

