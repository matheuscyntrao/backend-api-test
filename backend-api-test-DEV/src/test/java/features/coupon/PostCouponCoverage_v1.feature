#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado que possudo dados para Coupon-Service - v1 - GetIdCouponCoverage:
      | couponId   |
      | <couponId> |
    E possuo dados para CouponService - v1 - PostCouponCoverage:
      | columnName   | columnType   | columnValue   | relationalOperator   |
      | <columnName> | <columnType> | <columnValue> | <relationalOperator> |
    Quando executo CouponService - v1 - PostCouponCoverage
    Entao sistema processa CouponService - v1 - PostCouponCoverage:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - PostCouponCoverage "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                                     | statusCode | couponId | mensagem                               | columnName | columnType | columnValue | relationalOperator |
      | FB - Post Coverage Success DiscountType 1 | 201        | 6753     |                                        | UF         | BOOLEAN    | RS          | EQUAL              |
      | FA - Post Coverage Success DiscountType 2 | 201        | 6753     |                                        | CANAL      | BOOLEAN    | RS          | EQUAL              |
      | FE01 - ColumnName null                    | 400        | 6758     | O nome da coluna deve ser preenchido   |            | BOOLEAN    | RS          | EQUAL              |
      | FE01 - ColumnName null                    | 400        | 6758     | O nome da coluna deve ser preenchido   | null       | BOOLEAN    | RS          | EQUAL              |
      | FE02 - ColumnType null                    | 400        | 6758     | O tipo da coluna deve ser preenchido   | string     | null       | RS          | EQUAL              |
      | FE03 - RelationalOperator null            | 400        | 6758     | O tipo de operador deve ser preenchido | string     | BOOLEAN    | RS          | null               |
      | FE04 - ColumnValue null                   | 400        | 6758     | O valor da coluna deve ser preenchido  | UF         | BOOLEAN    | null        | EQUAL              |
      | FE05 - Coupon Inexistente                 | 404        | 0        | Cupom informado inexistente            | UF         | BOOLEAN    | RS          | EQUAL              |