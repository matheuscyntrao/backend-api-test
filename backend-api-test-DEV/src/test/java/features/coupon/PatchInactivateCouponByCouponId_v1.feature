#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp24
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - PatchInactivateCouponByCouponId:
      | id | <id> |
    Quando executo CouponService - v1 - PatchInactivateCouponByCouponId
    Entao sistema processa CouponService - v1 - PatchInactivateCouponByCouponId:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - PatchInactivateCouponByCouponId "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                 | statusCode | id   | mensagem                                                |
      | FB - ActivateCouponByCouponId Success | 204        | 7000 |                                                         |
      | FE - GetById Coupon Inválido          | 404        | 0    | Cupom informado inexistente                             |