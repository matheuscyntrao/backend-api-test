package enums.coupon;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.coupon.request.PostAndPutCouponCoverage_v1Request;

@Getter
@AllArgsConstructor
public enum Coverage {
    COVERAGE_201_OK {
        @Override
        public PostAndPutCouponCoverage_v1Request pojo() {
            return PostAndPutCouponCoverage_v1Request
                    .builder()
                    .columnName("UF")
                    .columnType("STRING")
                    .relationalOperator("IN")
                    .columnValue("RIO GRANDE DO SUL")
                    .build();
        }
    },
    COVERAGE_400_COLUMN_NAME_NULL {
        @Override
        public PostAndPutCouponCoverage_v1Request pojo() {
            PostAndPutCouponCoverage_v1Request body = Coverage.COVERAGE_201_OK.pojo();
            body.setColumnName(null);
            return body;
        }
    },
    COVERAGE_400_COLUMN_TYPE_NULL {
        @Override
        public PostAndPutCouponCoverage_v1Request pojo() {
            PostAndPutCouponCoverage_v1Request body = Coverage.COVERAGE_201_OK.pojo();
            body.setColumnType(null);
            return body;
        }
    },
    COVERAGE_400_COLUMN_VALUE_NULL {
        @Override
        public PostAndPutCouponCoverage_v1Request pojo() {
            PostAndPutCouponCoverage_v1Request body = Coverage.COVERAGE_201_OK.pojo();
            body.setColumnValue(null);
            return body;
        }
    },
    COVERAGE_400_RELATIONAL_OPERATOR_INVALIDO {
        @Override
        public PostAndPutCouponCoverage_v1Request pojo() {
            PostAndPutCouponCoverage_v1Request body = Coverage.COVERAGE_201_OK.pojo();
            body.setRelationalOperator(null);
            return body;
        }
    };

    public abstract PostAndPutCouponCoverage_v1Request pojo();
}
