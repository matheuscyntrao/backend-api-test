#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - GetCouponCustomerByCouponId:
      | couponId | <couponId> |
    Quando executo CouponService - v1 - GetCouponCustomerByCouponId
    Entao sistema processa CouponService - v1 - GetCouponCustomerByCouponId:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - GetCouponCustomerByCouponId "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                            | statusCode | couponId | mensagem                                                |
      | FB - Get Customer from CouponId With Customer    | 200        | 6753     |                                                         |
      | FA - Get Customer from CouponId Without Customer | 204        | 6754     |                                                         |
      | FE - Get Customer from Inavlid CouponId          | 404        | 0        | Cupom informado inexistente                             |