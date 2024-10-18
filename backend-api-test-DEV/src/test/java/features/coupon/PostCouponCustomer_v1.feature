#language: pt
@coupon-service @cupom2.0 @cupom2.0_sp3
Funcionalidade: CouponService - v1

  Esquema do Cenario:  CouponService - v1 <fluxo>
    Dado que possudo dados para Coupon-Service - v1 - GetIdCouponCustomer:
      | couponId   |
      | <couponId> |
    E possuo dados para CouponService - v1 - PostCouponCustomer:
      | columnName   | columnType   | columnValue   | relationalOperator   |
      | <columnName> | <columnType> | <columnValue> | <relationalOperator> |
    Quando executo CouponService - v1 - PostCouponCustomer
    Entao sistema processa CouponService - v1 - PostCouponCustomer:
      | statusCode | <statusCode> |
    E valido CouponService - v1 - PostCouponCustomer "<mensagem>"

    @FB @regressao
    Exemplos:
      | fluxo                          | statusCode | couponId | mensagem                                                | columnName | columnType | columnValue | relationalOperator |
      | FB - Post Customer Success     | 201        | 6753     |                                                         | string     | BOOLEAN    | string      | EQUAL              |
      | FE01 - ColumnName null         | 400        | 6753     | O nome da coluna deve ser preenchido                    | null       | BOOLEAN    | string      | EQUAL              |
      | FE02 - ColumnType null         | 400        | 6753     | O tipo da coluna deve ser preenchido                    | string     | null       | string      | EQUAL              |
      | FE03 - RelationalOperator null | 400        | 6753     | O tipo de operador deve ser preenchido                  | string     | BOOLEAN    | string      | null               |
      | FE04 - ColumnValue null        | 400        | 6753     | O valor da coluna deve ser preenchido                   | string     | BOOLEAN    | null        | EQUAL              |
      | FE05 - Customer Inexistente    | 404        | 0        | Cupom informado inexistente                             | string     | BOOLEAN    | string      | EQUAL              |