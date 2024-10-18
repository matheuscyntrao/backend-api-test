#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - GetCouponById:
      | id | <id> |
    Quando executo CouponService - v1 - GetCouponById
    Entao sistema processa CouponService - v1 - GetCouponById:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - GetCouponById "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                        | statusCode | id   | mensagem                                                |
      | FB - GetById Success         | 200        | 6753 |                                                         |
      | FE - GetById Coupon Inválido | 404        | 0    | Cupom informado inexistente                             |