package enums.coupon;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.coupon.request.PostAndPutCouponProduct_v1Request;

@Getter
@AllArgsConstructor
public enum Product {
    PRODUCT_201_OK {
        @Override
        public PostAndPutCouponProduct_v1Request pojo() {
            return PostAndPutCouponProduct_v1Request
                    .builder()
                    .columnName("ITEM")
                    .columnType("STRING")
                    .relationalOperator("EQUAL")
                    .columnValue("REVISTA")
                    .build();
        }
    },
    PRODUCT_400_COLUMN_NAME_NULL {
        @Override
        public PostAndPutCouponProduct_v1Request pojo() {
            PostAndPutCouponProduct_v1Request body = Product.PRODUCT_201_OK.pojo();
            body.setColumnName(null);
            return body;
        }
    },
    PRODUCT_400_COLUMN_TYPE_NULL {
        @Override
        public PostAndPutCouponProduct_v1Request pojo() {
            PostAndPutCouponProduct_v1Request body = Product.PRODUCT_201_OK.pojo();
            body.setColumnType(null);
            return body;
        }
    },
    PRODUCT_400_COLUMN_VALUE_NULL {
        @Override
        public PostAndPutCouponProduct_v1Request pojo() {
            PostAndPutCouponProduct_v1Request body = Product.PRODUCT_201_OK.pojo();
            body.setColumnValue(null);
            return body;
        }
    },
    PRODUCT_400_RELATIONAL_OPERATOR_INVALIDO {
        @Override
        public PostAndPutCouponProduct_v1Request pojo() {
            PostAndPutCouponProduct_v1Request body = Product.PRODUCT_201_OK.pojo();
            body.setRelationalOperator(null);
            return body;
        }
    };

    public abstract PostAndPutCouponProduct_v1Request pojo();
}
