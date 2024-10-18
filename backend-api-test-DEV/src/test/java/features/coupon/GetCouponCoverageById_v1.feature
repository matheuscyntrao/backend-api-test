#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - GetCouponCoverageByCouponId:
      | couponId | <couponId> |
    Quando executo CouponService - v1 - GetCouponCoverageByCouponId
    Entao sistema processa CouponService - v1 - GetCouponCoverageByCouponId:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - GetCouponCoverageByCouponId "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                            | statusCode | couponId  | mensagem                                                |
      | FB - Get Coverage from CouponId With Coverage    | 200        | 6754      |                                                         |
      | FA - Get Coverage from CouponId Without Coverage | 204        | 6760      |                                                         |
      | FE - Get Coverage from Inavlid CouponId          | 404        | 0         | Cupom informado inexistente                             |