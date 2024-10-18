#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp24
Funcionalidade: CouponService - v1

  Esquema do Cenario:  OmniDashBoardBff - v1 <fluxo>
    Dado possuo dados para OmniDashBoardBff - v1 - GetCouponById:
      | id | <id> |
    Quando executo OmniDashBoardBff - v1 - GetCouponById
    Entao sistema processa OmniDashBoardBff - v1 - GetCouponById:
      | statusCode | <statusCode> |
    @FB @regressao
    Exemplos:
      | fluxo                        | statusCode | id   |
      | FB - GetById                 | 200        | 6761 |
      | FA - GetById Sem coverage    | 200        | 6755 |
      | FA - GetById Sem item        | 200        | 6760 |
      | FA - GetById Sem customer    | 200        | 6759 |
      | FE - GetById Coupon Inválido | 404        | 0    |