#language: pt
@cliente-service @plataforma
Funcionalidade: Cliente-v2-PostClientesIdclienteCartoes

  @FB
  Cenario: Post Clientes Idcliente Cartoes v2 - Cadastro Simples
    Dado possuo dados para Cliente - v2 - PostCliente generate
    Quando executo Cliente - v2 - PostCliente
    Entao sistema processa Cliente - v2 - PostCliente:
      | statusCode | 200 |



  Esquema do Cenario: Post Clientes Idcliente Cartoes v2 - <fluxo>
    Dado possuo dados para Cliente - v2 - PostCliente:
      | codEntidadeComercial   | nome   | cpf   | cnpj   | dtNascimento   | sexo   | estadoCivil   | receberNewsletter   | emailAlternativo1   | emailAlternativo2   | rg   |
      | <codEntidadeComercial> | <nome> | <cpf> | <cnpj> | <dtNascimento> | <sexo> | <estadoCivil> | <receberNewsletter> | <emailAlternativo1> | <emailAlternativo2> | <rg> |
    E possuo dados para Cliente - v2 - PostCliente contatos:
      | codMeioComunicacao | ddi | ddd | numero | ramal | email           | observacao | codTipoComunicacao | descTipoComunicacao | preferencial |
      | 13913508           | 55  | 0   | 0      | 0     | teste@teste.com | null       | 4                  | E-MAIL              | S            |
    E possuo dados para Cliente - v2 - PostCliente enderecos:
      | codEntidadeComercial | seqEndEntidadeComercial | identificador | cep      | codLogradouro | logradouro | numero | complemento | bairro     | codCidade | cidade       | uf | referencia | preferencial |
      |                      | 6348455                 | Casa          | 90680050 | 119192        | DONA LUCIA | 33     | apto 201    | PETROPOLIS | 7718      | PORTO ALEGRE | RS |            | S            |
    E possuo dados para Cliente - v2 - PostCliente usuario:
      | email               | senha  |
      | teste1146@teste.com | 102030 |
    Quando executo Cliente - v2 - PostCliente
    Entao sistema processa Cliente - v2 - PostCliente:
      | statusCode | <statusCode> |

    @FB @regressao
    Exemplos:
      | fluxo | codEntidadeComercial | nome        | cpf         | cnpj | dtNascimento | sexo | estadoCivil | receberNewsletter | emailAlternativo1 | emailAlternativo2 | rg   | statusCode | mensagem                                                                                                 |
      | FB    |                      | Teste Zmuda | 41428628045 |      | 02/10/1983   | M    | 1           | N                 |                   |                   | null | 200        | Prezado usuário, este CPF já encontra-se cadastrado. Por favor, entre em contato com o SAC: 0800 51 1800 |