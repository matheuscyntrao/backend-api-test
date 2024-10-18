package enums.domino.puc;


import dataSource.mongo.shoppingCart.PucDatastore;
import entity.domino.puc.ItemsValidatorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public enum PucWalletValidationItem {
    SUCESSO {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucWalletValidationItemBuilder.builderParam(
                    entity.getCode().toString(), "", entity.getWallet().get(0).getCode().toString()
            );
        }
    },
    CAMPO_CLIENTE_OBRIGATORIO {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucWalletValidationItemBuilder.builderParam(
                    "", "", entity.getWallet().get(0).getCode().toString()
            );
        }
    },
    CAMPO_ITEM_OBRIGATORIO {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucWalletValidationItemBuilder.builderParam(
                    entity.getCode().toString(), "", ""
            );
        }
    },
    TODOS_CAMPOS_NULL {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucWalletValidationItemBuilder.builderParam(
                    "", "", ""
            );
        }
    },
    ITEM_INVALIDO {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomInvalidItem();
            return PucWalletValidationItemBuilder.builderParam(
                    entity.getCode().toString(), "", entity.getWallet().get(0).getCode().toString()
            );
        }
    },
//    CLIENTE_INVALIDO {
//        @Override
//        public Map<String, String> pojo() {
//            ItemsValidatorEntity entity = new PucDatastore().getRandomInvalidClient();
//            return PucWalletValidationItemBuilder.builderParam(
//                    entity.getCode().toString(), "", entity.getWallet().get(0).getCode().toString()
//            );
//        }
//    },
    PREENCHER_TODOS_CAMPOS{
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucWalletValidationItemBuilder.builderParam(
                    entity.getCode().toString(), entity.getDocument(), "501640"
            );
        }
    };

    public abstract Map<String, String> pojo();
    }

    class PucWalletValidationItemBuilder {
    public static Map<String, String> builderParam(String clientCode, String document, String itemCode){
        return Map.of("clientCode", clientCode
                , "document", document
                ,"itemCode", itemCode
        );
    }
    }