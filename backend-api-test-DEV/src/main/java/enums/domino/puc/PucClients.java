package enums.domino.puc;


import dataSource.mongo.shoppingCart.PucDatastore;
import entity.domino.puc.ItemsValidatorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum PucClients {
    SUCESSO_CODE {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucClientsBuilder.builderParam(
                    entity.getCode().toString(), ""
            );
        }
    },
    SUCESSO_DOCUMENT{
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucClientsBuilder.builderParam(
                    "", entity.getDocument()
            );
        }
    },
    CLIENTE_NULL {
        @Override
        public Map<String, String> pojo() {
            ItemsValidatorEntity entity = new PucDatastore().getRandomItem();
            return PucClientsBuilder.builderParam(
                    "", ""
            );
        }
    };
    public abstract Map<String, String> pojo();
    }

class PucClientsBuilder {
public static Map<String, String> builderParam(String code, String document){
    return Map.of("code", code
            , "document", document
    );
}
}