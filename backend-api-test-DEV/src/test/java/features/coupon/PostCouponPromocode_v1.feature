#language: pt

Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>

    Dado possuo dados para CouponService - v1 - GetUsedCoupon:
    E possuo dados para CouponService - v1 - GetStartAndEndDate:
      | startDate | endDate          |
      | today     | 1 month from now |
    E possuo dados para CouponService - v1 - GetRandomPromocode:
    E possuo dados para CouponService - v1 - E2EPostCoupon:
      | bonusValue | cuponable | description | detailedDescription | discountPercentage | discountType        | durationDays | dynamicPromocode | idCampaign | individualUses | limitUses | minimumValue | price | pub  | rebateValue | rebatePercentage | active | title |
      | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | false            | 1          | 1              | 1         | null         | null  | true | 1           | null             | true   | title |
    E possuo dados para CouponService - v1 - E2EPatchActivateCouponByCouponId:
    E possuo dados para CouponService - v1 - E2EGetCouponWalletByParameters:

#DADO QUE TENHO UM PROMOCODE
#E ELE É DE USO ÚNICO POR CPF
#E EU JÁ UTILIZEI ELE
#QUANDO TENTO ADICIONAR NA CARTEIRA
#ENTAO DEVE INFORMAR QUE O PROMOCODE JÁ FOI UTILIZADO


    Exemplos:
      | fluxo                       |
      | FB - Promocode ja utilizado |