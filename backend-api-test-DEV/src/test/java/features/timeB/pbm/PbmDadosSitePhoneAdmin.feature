#language: pt
@pbm-service
Funcionalidade: Pbm - Dados Site Phone Admin

  Esquema do Cenario: Pbm - Dados Site Phone Admin <fluxo>
    Dado possuo dados para Pbm - Dados Site Phone Admin
      | meioDeContatoPdv | <meioDeContatoPdv> |
    Quando executo Pbm - Dados Site Phone Admin
    Então valido Pbm - Dados Site Phone Admin

    @FB @regressao
    Exemplos:
      | fluxo         | meioDeContatoPdv                                |
      | FB - EXEMPLO1 | 'CADASTRO: WWW.STARBEM.COM.BR OU 0800 771 8700' |

    @FA @regressao
    Exemplos:
      | fluxo            | meioDeContatoPdv                         |
      | FA001 - EXEMPLO2 | 'http://www.soumaisvida.com.br/Cadastro' |
      | FA002 - EXEMPLO3 | 08007031550                              |