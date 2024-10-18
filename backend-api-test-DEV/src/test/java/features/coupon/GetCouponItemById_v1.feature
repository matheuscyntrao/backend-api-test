#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - GetCouponProductByCouponId:
      | couponId | <couponId> |
    Quando executo CouponService - v1 - GetCouponProductByCouponId
    Entao sistema processa CouponService - v1 - GetCouponProductByCouponId:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - GetCouponProductByCouponId "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                     | statusCode | couponId | mensagem                                                |
      | FB - Get Item from CouponId With Itens    | 200        | 9000     |                                                         |
      | FA - Get Item from CouponId Without Items | 204        | 6754     |                                                         |
      | FE - Get Item from Inavlid CouponId       | 404        | 0        | Cupom informado inexistente                             |