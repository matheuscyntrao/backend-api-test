#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1


  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado possuo dados para CouponService - v1 - PostToPutCoupon:
      | bonusValue | cuponable | description | detailedDescription | discountPercentage | discountType        | durationDays | dynamicPromocode | endDate             | idCampaign | individualUses | limitUses | minimumValue | price | promocode | pub  | rebateValue | rebatePercentage | startDate           | active | title        |
      | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null  | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
    E eu edito CouponService - v1 - PutCouponData:
      | bonusValue   | cuponable   | description   | detailedDescription   | discountPercentage   | discountType   | durationDays   | dynamicPromocode   | endDate   | idCampaign   | individualUses   | limitUses   | minimumValue   | price   | promocode   | pub   | rebateValue   | rebatePercentage   | startDate   | active   | title   |
      | <bonusValue> | <cuponable> | <description> | <detailedDescription> | <discountPercentage> | <discountType> | <durationDays> | <dynamicPromocode> | <endDate> | <idCampaign> | <individualUses> | <limitUses> | <minimumValue> | <price> | <promocode> | <pub> | <rebateValue> | <rebatePercentage> | <startDate> | <active> | <title> |
    Quando executo CouponService - v1 - PutCouponData
    Entao sistema processa CouponService - v1 - PutCouponData:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - PutCouponData "<message>"

    @FB @regressao
    Exemplos:
      | fluxo                                                    | statusCode | message                                                                                                 | bonusValue | cuponable | description | detailedDescription | discountPercentage | discountType        | durationDays | dynamicPromocode | endDate             | idCampaign | individualUses | limitUses | minimumValue | price     | promocode | pub  | rebateValue | rebatePercentage | startDate           | active | title        |
      | FB - Cadastro de Coupon                                  | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE01 - Description Not Null                              | 400        | Os Detalhes da descrição do cupom deve ser informada                                                    | null       | true      | Descrição 1 | null                | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE02 - DetailDescription Not Null                        | 400        | Descrição do cupom deve ser informada                                                                   | null       | true      | null        | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE03 - Public Not Null                                   | 400        | O campo público não pode ser nulo                                                                       | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | null | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE04 - Couponable Not Null                               | 400        | O campo cuponable não pode ser nulo                                                                     | null       | null      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE05 - Limit Uses Not Null                               | 400        | Deve ser definido o limite de usos do cupom                                                             | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | null      | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE06 - StartDate Not Null                                | 400        | A data de início deve ser preenchida                                                                    | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | null                | true   | titulo cupom |
      | FE07 - EndDate > StartDate                               | 400        | Data Final deve ser maior que a Data Inicial                                                            | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2018 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2024 00:00:00 | true   | titulo cupom |
      | FA01 - StartDate > Today                                 | 400        | Data Inicial deve ser igual ou maior que a data atual                                                   | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2010 00:00:00 | true   | titulo cupom |
#      | FE09 - Duration Days Not Null                            | 400        | Deve ser definido tempo de duração                                                                      | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | null         | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA02 - Promocode Can Be Null                             | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | null      | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE10 - DynamicPromocode Not Null                         | 400        | Deve ser informado de a promoção é dinâmica ou não                                                      | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | null             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 11        | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE11 - DiscountType Not Null                             | 400        | O tipo de desconto deve ser informado                                                                   | null       | true      | Descrição 1 | Descrição detalhada | null               | null                | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA03 - DiscountType Pode Ser 1                           | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE12 - DiscountPercentage Valor Negativo                 | 400        | Valor mínimo de porcentagem de desconto excedido                                                        | 1          | true      | Descrição 1 | Descrição detalhada | -1                 | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA04 - DiscountPercentage Valor Mínimo: 0                | 400        | Para tipo de desconto diferente de Porcentagem Desconto não deve ser informado o Percentual de Desconto | 1          | true      | Descrição 1 | Descrição detalhada | 0                  | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA05 - DiscountPercentage Valor Máximo: 99.99            | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 99.99              | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE - DiscountPercentage Valor Máximo Extrapolado : 99.99 | 400        | Valor máximo de porcentagem de desconto excedido                                                        | null       | true      | Descrição 1 | Descrição detalhada | 101                | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA06 - DiscountType Pode Ser 2                           | 200        |                                                                                                         | 22.22      | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE13 - Price Valor Negativo                              | 400        | Preço mínimo de desconto excedido                                                                       | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | -1        | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA07 - DiscountType Pode Ser 3                           | 200        |                                                                                                         | 11         | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | null        | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE14 - RebatePercentage Valor Negativo                   | 400        | Percentual de aporte não pode ser menor que 1                                                           | 1          | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | null        | -1               | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA08 - RebatePercentage Valor Minimo: 1                  | 200        |                                                                                                         | 1          | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | null        | 1                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA09 - RebatePercentage Valor Máximo: 100                | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 1         | QA_TEST   | true | null        | 100              | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE15 - RebatePercentage Valor Máximo Extrapolado: 101    | 400        | Percentual de aporte não pode ser maior que 100                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 1         | QA_TEST   | true | null        | 101              | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE16 - RebatePercentage Informado com DiscontType 4      | 400        | Não pode ser informado porcentagem de aporte para tipos de desconto 4 (Frete grátis)  e 5 (Mensagem)    | null       | true      | Descrição 1 | Descrição detalhada | null               | FREE_SHIPPING       | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 100              | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE17 - RebatePercentage Informado com DiscontType 5      | 400        | Não pode ser informado porcentagem de aporte para tipos de desconto 4 (Frete grátis)  e 5 (Mensagem)    | null       | true      | Descrição 1 | Descrição detalhada | null               | MESSAGE             | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 100              | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA10 - DiscountType Pode Ser 4                           | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | FREE_SHIPPING       | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA11 - DiscountType Pode Ser 5                           | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | MESSAGE             | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA12 - RebateValue - DiscountType 1                      | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 99               | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA13 - RebateValue - DiscountType 2                      | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 1         | QA_TEST   | true | null        | 9                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FA14 - RebateValue - DiscountType 3                      | 200        |                                                                                                         | 1          | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | null        | 9                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE19 - RebateValue - DiscountType 4                      | 400        | Não pode ser informado porcentagem de aporte para tipos de desconto 4 (Frete grátis)  e 5 (Mensagem)    | null       | true      | Descrição 1 | Descrição detalhada | null               | FREE_SHIPPING       | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 9                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE20 - RebateValue - DiscountType 5                      | 400        | Não pode ser informado porcentagem de aporte para tipos de desconto 4 (Frete grátis)  e 5 (Mensagem)    | null       | true      | Descrição 1 | Descrição detalhada | null               | MESSAGE             | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 9                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE21 - Active Not Null                                   | 400        | Deve ser informado se o cupom vai estar ativo                                                           | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | null | null        | 1                | 20/01/2025 00:00:00 | null   | titulo cupom |
      | FE22 - RebateValue - Validação de tamanho normal         | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | 10000000    | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE23 - RebateValue - Validação de tamanho máximo         | 400        | O valor de aporte informado deve possuir no máximo 8 dígitos e precisão decimal de 2 dígitos            | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | 100000000   | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE24 - BonusValue - Validação de tamanho normal          | 200        |                                                                                                         | 10000000   | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | null        | 1                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE25 - BonusValue - Validação de tamanho máximo          | 400        | O valor de bônus informado deve possuir no máximo 8 dígitos e precisão decimal de 2 dígitos             | 100000000  | true      | Descrição 1 | Descrição detalhada | null               | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | null      | QA_TEST   | true | null        | 1                | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE26 - Price - Validação de tamanho normal               | 200        |                                                                                                         | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 10000000  | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE27 - Price - Validação de tamanho máximo               | 400        | O preço informado deve possuir no máximo 8 dígitos e precisão decimal de 2 dígitos                      | null       | true      | Descrição 1 | Descrição detalhada | null               | FIXED_PRICE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | null         | 100000000 | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE28 - RebateValue - Valor negativo                      | 400        | Valor de aporte não pode ser menor que 0 (Zero)                                                         | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | -1          | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE29 - BonusValue - Valor negativo                       | 400        | Informar somente valores positivos para valor de bônus                                                  | -1         | true      | Descrição 1 | Descrição detalhada | 1                  | BONUS_VALUE         | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | null      | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |
      | FE30 - Price - Valor negativo                            | 400        | Preço mínimo de desconto excedido                                                                       | null       | true      | Descrição 1 | Descrição detalhada | 1                  | PERCENTAGE_DISCOUNT | 1            | true             | 21/01/2025 00:00:00 | 1          | 1              | 1         | 1            | -1        | QA_TEST   | true | 1           | null             | 20/01/2025 00:00:00 | true   | titulo cupom |