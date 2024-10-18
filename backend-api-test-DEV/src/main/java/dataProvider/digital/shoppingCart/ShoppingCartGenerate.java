package dataProvider.digital.shoppingCart;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.service.RandomService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.digital.shoppingCart.request.ShoppingRequest_v1;
import org.apache.commons.lang3.RandomUtils;
import org.jsmart.zerocode.core.utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public enum ShoppingCartGenerate {
    NORMAL {
        @Override
        public ShoppingRequest_v1 pojo() throws JsonProcessingException {
            return ShoppingRequest_v1.builder().channel("SITE").codCustomer(9169339).subsidiaryCode(101).build();
        }
    }, RANDOM {
        @Override
        public ShoppingRequest_v1 pojo() throws JsonProcessingException {
            return ShoppingRequest_v1.builder().channel("SITE").codCustomer(ShoppingCartGenerateList.getCustomerCode()).subsidiaryCode(101).build();
        }
    }, SEM_CONTATO {
        @Override
        public ShoppingRequest_v1 pojo() throws JsonProcessingException {
            return ShoppingRequest_v1.builder().channel("SITE").codCustomer(133196913).subsidiaryCode(101).build();
        }
    }, NAO_IDENTIFICADO {
        @Override
        public ShoppingRequest_v1 pojo() throws JsonProcessingException {
            return ShoppingRequest_v1.builder().channel("SITE").subsidiaryCode(101).build();
        }
    },
    SEM_ENREDECO {
        @Override
        public ShoppingRequest_v1 pojo() {
            return ShoppingRequest_v1.builder().channel("SITE").codCustomer(133196913).subsidiaryCode(101).build();
        }
    };

    public abstract ShoppingRequest_v1 pojo() throws JsonProcessingException;
}

class ShoppingCartGenerateList {
    public static Integer getCustomerCode() {
        List<Integer> givenList = Arrays.asList(
                1165711
                , 1165715
                , 1220699
                , 1220700
                , 1236610
                , 1244610
                , 1207262
                , 1207264
                , 1207261
                , 1163872
                , 1253546
                , 1257539
                , 1259653
                , 1259662
                , 1223134
                , 1085105
                , 1085193
                , 1191769
                , 1227056
                , 1208667
                , 1165644
                , 1220540
                , 1181186
                , 1269539
                , 1269557
                , 1268546
                , 1220578
                , 1199790
                , 1263633
                , 1207306
                , 1085860
                , 1085871
                , 1165665
                , 1207310
                , 1263670
                , 1263673
                , 1156377
                , 1260609
                , 1247268
                , 1259866
                , 1199816
                , 1273553
                , 1261682
                , 1190873
                , 1084969
                , 1084971
                , 1084972
                , 1084973
                , 1084978
        );
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }
}

