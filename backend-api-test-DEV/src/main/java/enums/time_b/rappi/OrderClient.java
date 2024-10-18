package enums.time_b.rappi;

import helpers.CPF;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.rappi.request.PostOrderRequestV1Client;
import utils.PatternRegex;
import utils.service.Cache;

@AllArgsConstructor
@Getter
public enum OrderClient {
    CLIENTE_CADASTRADO {
        @Override
        public PostOrderRequestV1Client pojo() {
            return PostOrderRequestV1Client.builder()
                    .firstName("Teste")
                    .lastName("Rappi")
                    .identification("15326101068")
                    .phone("51 999999999")
                    .email("teste@marketplacerappi.com")
                    .build();
        }
    },
    CLIENTE_NAO_CADASTRADO {
        @Override
        public PostOrderRequestV1Client pojo() {
            return PostOrderRequestV1Client.builder()
                    .firstName(Cache.faker.name().firstName())
                    .lastName(Cache.faker.name().lastName())
                    .identification(CPF.geraCPF())
                    .phone(Cache.faker.bothify("51 9########"))
                    .email(Cache.faker.bothify(PatternRegex.FAKER_EMAIL))
                    .build();
        }
    };

    public abstract PostOrderRequestV1Client pojo();
}