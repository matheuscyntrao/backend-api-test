#language: pt
@notificacao-service
Funcionalidade: Notificacao-Hub-Email

  Esquema do Cenario: Notificacao-Hub-Email - <fluxo>
    Dado que possuo dados para Notificacao - Hub - Email:
      | PEDIDO                 | <PEDIDO>                 |
      | TIPO_PEDIDO            | <TIPO_PEDIDO>            |
      | CODIGO_SITUACAO_PEDIDO | <CODIGO_SITUACAO_PEDIDO> |
      | FORMA_DE_ENTREGA       | <FORMA_DE_ENTREGA>       |
    E efetuo Notificacao - Hub - Email "<fluxo>"


    @FB @regressao
    Exemplos:
      | fluxo | PEDIDO         | TIPO_PEDIDO | CODIGO_SITUACAO_PEDIDO   | FORMA_DE_ENTREGA |
      | FA001 | 12010005000000 | DIGITAL     | IMPRESSO                 | LOCKER           |
      | FA002 | 12020005000000 | ALO_PANVEL  | IMPRESSO                 | LOCKER           |
      | FA003 | 12000001100000 | DIGITAL     | NA_ENTREGA               | LOCKER           |
      | FA004 | 12000005000004 | DIGITAL     | IMPRESSO                 | RETIRADA_BALCAO  |
      | FA005 | 12000005100004 | DIGITAL     | AGUARDANDO_REMESSA_DO_CD | PAC              |
      | FA006 | 12000006000004 | DIGITAL     | CUPOM_IMPRESSO           | PAC              |
      | FA007 | 12000005000000 | DIGITAL     | IMPRESSO                 | RETIRADA_BALCAO  |
      | FA008 | 12000005000008 | DIGITAL     | IMPRESSO                 | LOCKER           |
      | FA009 | 12000007000000 | DIGITAL     | CANCELADO                | LOCKER           |
      | FA010 | 12000001100000 | DIGITAL     | NA_ENTREGA               | LOCKER           |
      | FA011 | 12000001200000 | DIGITAL     | ENTREGUE                 | LOCKER           |
      | FA012 | 12000006000004 | DIGITAL     | CUPOM_IMPRESSO           | PAC              |
      | FA013 | 12000009000000 | DIGITAL     | REJEITADO                | LOCKER           |
      | FA014 | 12000003700008 | DIGITAL     | PEDIDO_NO_LOCKER         | LOCKER           |
      | FA015 | 12000006000004 | DIGITAL     | CUPOM_IMPRESSO           | PAC              |
      | FA016 | 12000005000000 | DIGITAL     | IMPRESSO                 | LOCKER           |


#   TIPO_DE_PEDIDO	CODIGO_DA_SITUACAO_PEDIDO	        FORMA_DE_ENTREGA
#   I	            5  IMPRESSO(5)
#   A	            5  IMPRESSO(5)
#	                11 NA_ENTREGA(11)
#	                5  IMPRESSO(5)                      4  RETIRADA_BALCAO(4)
#	                51 AGUARDANDO_REMESSA_DO_CD(51)	    4  RETIRADA_BALCAO(4)
#	                6  CUPOM_IMPRESSO(6)                4  RETIRADA_BALCAO(4)
# 	                5  IMPRESSO(5)
#	                5  IMPRESSO(5)                      8  LOCKER(8)
#	                7  CANCELADO(7)
#	                11 NA_ENTREGA(11)
#	                12  ENTREGUE(12)
#	                6	CUPOM_IMPRESSO(6)               4  RETIRADA_BALCAO(4)
#	                9  REJEITADO(9)
#	                37 PEDIDO_NO_LOCKER(37)             8  LOCKER(8)
#	                6  CUPOM_IMPRESSO(6)                4  RETIRADA_BALCAO(4)
#	                5  IMPRESSO(5)

#    OrderStatusEnum
#    DESCONTO(1),
#    PENDENTE(2),
#    EM_ALTERACAO(3),
#    ALTERADO(4),
#    IMPRESSO(5),
#    CUPOM_IMPRESSO(6),
#    CANCELADO(7),
#    INTERNET_PENDENTE(8),
#    REJEITADO(9),
#    FINALIZADO(10),
#    NA_ENTREGA(11),
#    ENTREGUE(12),
#    NA_ESPERA(13),
#    INCOMPLETO(14),
#    EM_COBRANCA(15),
#    COBRADO(16),
#    AGUARDANDO_CONFIRMACAO(17),
#    AGUARDANDO_PAGAMENTO(18),
#    EM_ANALISE(19),
#    EXPEDIDO(20),
#    AGUARDANDO_RETORNO(21),
#    CHEGADA_NA_FILIAL(22),
#    EMITINDO_CUPOM(23),
#    NAO_ENTREGUE(24),
#    ETIQUETA_IMPRESSA(25),
#    EMITINDO_ETIQUETA(26),
#    AGENDAMENTO_PENDENTE(27),
#    AGENDAMENTO_EM_ANALISE(28),
#    AGENDAMENTO_LIBERADO(29),
#    AGENDAMENTO_EM_PROCESSO(30),
#    PEDIDO_COM_TOKEN(31),
#    PEDIDO_COM_TOKEN_EM_ANALISE(32),
#    PEDIDO_COM_TOKEN_LIBERADO(33),
#    PEDIDO_COM_TOKEN_EM_PAGAMENTO(34),
#    TRANSFERENCIA_IMPRESSA(35),
#    LOTE_PENDENTE(36),
#    PEDIDO_NO_LOCKER(37),
#    EM_ANALISE_MANUAL(39),
#    PEDIDO_PIP_CONFERIDO(40),
#    NOTA_PIP_GERADA(41),
#    NOTA_PIP_GERAR_MANUAL(42),
#    EM_SEPARACAO(50),
#    AGUARDANDO_REMESSA_DO_CD(51),
#    RECEBIDO_DO_CD(52);


#   DeliveryTypeEnum {
#    RAPIDA(1),
#    EXPRESS(2),
#    PROGRAMADA(3),
#    RETIRADA_BALCAO(4),
#    COMBINADA(5),
#    MULTICANAL(6),
#    BABY_DELIVERY(7),
#    LOCKER(8);


#   OrderTypeEnum {
#    DIGITAL,
#    SUBSIDIARY,
#    ALO_PANVEL;
