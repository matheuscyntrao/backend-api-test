#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado que possudo dados para Coupon-Service - v1 - GetIdCouponProduct:
      | couponId   |
      | <couponId> |
    E possuo dados para CouponService - v1 - PostCouponProduct:
      | columnName   | columnType   | columnValue   | relationalOperator   |
      | <columnName> | <columnType> | <columnValue> | <relationalOperator> |
    Quando executo CouponService - v1 - PostCouponProduct
    Entao sistema processa CouponService - v1 - PostCouponProduct:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - PostCouponProduct "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                 | statusCode | couponId | mensagem                                                             | columnName | columnType | columnValue | relationalOperator |
      | FB - Post Item Success DiscountType 1 | 201        | 9001     |                                                                      | string     | STRING     | string      | EQUAL              |
      | FA - Post Item Success DiscountType 2 | 201        | 9000     |                                                                      | string     | STRING     | string      | EQUAL              |
      | FE01 - ColumnName null                | 400        | 6758     | O nome da coluna deve ser preenchido                                 | null       | STRING     | string      | EQUAL              |
      | FE02 - ColumnType null                | 400        | 6758     | O tipo da coluna deve ser preenchido                                 | string     | null       | string      | EQUAL              |
      | FE03 - RelationalOperator null        | 400        | 6758     | O tipo de operador deve ser preenchido                               | string     | STRING     | string      | null               |
      | FE04 - ColumnValue null               | 400        | 6758     | O valor da coluna deve ser preenchido                                | string     | STRING     | null        | EQUAL              |
      | FE05 - Coupon Inexistente             | 404        | 0        | Cupom informado inexistente                                          | string     | STRING     | string      | EQUAL              |
      | FE05 - DiscountType 3                 | 400        | 6799     | Não foi possível cadastrar o produto de cupom para o cupom informado | string     | STRING     | string      | EQUAL              |
      | FE05 - DiscountType 4                 | 400        | 6780     | Não foi possível cadastrar o produto de cupom para o cupom informado | string     | STRING     | string      | EQUAL              |
