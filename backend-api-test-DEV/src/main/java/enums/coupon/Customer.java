package enums.coupon;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.coupon.request.PostAndPutCouponCustomer_v1Request;

@Getter
@AllArgsConstructor
public enum Customer {
    CUSTOMER_201_OK {
        @Override
        public PostAndPutCouponCustomer_v1Request pojo() {
            return PostAndPutCouponCustomer_v1Request
                    .builder()
                    .columnName("CPF")
                    .columnType("STRING")
                    .relationalOperator("IN")
                    .columnValue("03137213002")
                    .build();
        }
    },
    CUSTOMER_400_COLUMN_NAME_NULL {
        @Override
        public PostAndPutCouponCustomer_v1Request pojo() {
            PostAndPutCouponCustomer_v1Request body = Customer.CUSTOMER_201_OK.pojo();
            body.setColumnName(null);
            return body;
        }
    },
    CUSTOMER_400_COLUMN_TYPE_NULL {
        @Override
        public PostAndPutCouponCustomer_v1Request pojo() {
            PostAndPutCouponCustomer_v1Request body = Customer.CUSTOMER_201_OK.pojo();
            body.setColumnType(null);
            return body;
        }
    },
    CUSTOMER_400_COLUMN_VALUE_NULL {
        @Override
        public PostAndPutCouponCustomer_v1Request pojo() {
            PostAndPutCouponCustomer_v1Request body = Customer.CUSTOMER_201_OK.pojo();
            body.setColumnValue(null);
            return body;
        }
    },
    CUSTOMER_400_RELATIONAL_OPERATOR_INVALIDO {
        @Override
        public PostAndPutCouponCustomer_v1Request pojo() {
            PostAndPutCouponCustomer_v1Request body = Customer.CUSTOMER_201_OK.pojo();
            body.setRelationalOperator(null);
            return body;
        }
    };

    public abstract PostAndPutCouponCustomer_v1Request pojo();
}
