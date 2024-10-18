#language: pt
@coupon-service @cupom2.0
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>

    Dado possuo dados para CouponService - v1 - BuscarCPFDBR
    E possuo dados para CouponService - v1 - GetStartAndEndDate:
      | startDate | endDate          |
      | today     | 1 month from now |
    E possuo dados para CouponService - v1 - GetRandomPromocode:
    E possuo dados para CouponService - v1 - E2EPostCoupon:
      | bonusValue | cuponable | description | detailedDescription | discountPercentage | discountType        | durationDays | dynamicPromocode | idCampaign | individualUses | limitUses | minimumValue | price | pub  | rebateValue | rebatePercentage | active | title |
      | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | false            | 1          | 1              | 1         | null         | null  | true | 1           | null             | true   | title |
    E possuo dados para CouponService - v1 - E2EPatchActivateCouponByCouponId:
    E possuo dados para CouponService - v1 - E2EGetCouponWalletByParameters:
      | channel |
      | LOJA    |
    E valido CouponService - v1 - DoesNotContainsPromocode:
    E possuo dados para CouponService - v1 - E2EPostCouponCoverage:
      | columnName | columnType | columnValue | relationalOperator |
      | CANAL      | STRING     | LOJA        | EQUAL              |
    E valido CouponService - v1 - PostCouponCoverage:
      | statusCode | 201 |
    E possuo dados para CouponService - v1 - E2EPostCouponCustomer:
      | columnName | columnType | columnValue | relationalOperator |
      | SEXO       | STRING     | F           | EQUAL              |
    E valido CouponService - v1 - CouponValidoPerfil
    Quando executo CouponService - v1 - AddCouponCarteira:
      | channel |
      | LOJA    |
    Entao valido CouponService - v1 - StatusCode201:
      | statusCode | 201 |
    E valido CouponService - v1 - E2EPatchInactivateCouponByCouponId:

    @FB @regressao
    Exemplos:
      | fluxo                                 |
      | FB - Cenário de ativação de promocode |
      | FA - Cenário promocode já adicionado  |
