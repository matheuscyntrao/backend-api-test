package enums.time_b.rappi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.rappi.request.PostOrderRequestV1Address;

@AllArgsConstructor
@Getter
public enum OrderAddress {

    ENDERECO_LOGRADOURO {
        @Override
        public PostOrderRequestV1Address pojo() {
            return PostOrderRequestV1Address.builder()
                    .streetAddress("Rua Jerônimo Coelho")
                    .number("45345")
                    .description("")
                    .neighborhood("Centro Histórico")
                    .city("Porto Alegre")
                    .region("RS")
                    .zipCode("90010241")
                    .build();
        }
    },
    ENDERECO_LOCALIDADE {
        @Override
        public PostOrderRequestV1Address pojo() {
            return PostOrderRequestV1Address.builder()
                    .streetAddress("Industrial Belgraf")
                    .number("865")
                    .description("")
                    .neighborhood("Industrial")
                    .city("Eldorado do Sul")
                    .region("RS")
                    .zipCode("92990000")
                    .build();
        }
    },
    ENDERECO_SEM_MATCH_FONETICO {
        @Override
        public PostOrderRequestV1Address pojo() {
            return PostOrderRequestV1Address.builder()
                    .streetAddress("Teste 123")
                    .number("865")
                    .description("")
                    .neighborhood("Industrial")
                    .city("Eldorado do Sul")
                    .region("RS")
                    .zipCode("92990000")
                    .build();
        }
    };

    public abstract PostOrderRequestV1Address pojo();
}