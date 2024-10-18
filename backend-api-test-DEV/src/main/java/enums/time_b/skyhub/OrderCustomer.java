package enums.time_b.skyhub;

import com.github.javafaker.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestCustomer;
import utils.CPF;
import utils.service.Cache;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum OrderCustomer {
    CLIENTE_CADASTRADO {
        @Override
        public OrderRequestCustomer pojo() {
            return OrderRequestCustomer.builder()
                    .name("JOAO DA SILVA")
                    .email("9485910000000@exemplo.com.br")
                    .dateOfBirth("1995-01-01")
                    .gender("male")
                    .vatNumber("12935970071")
                    .phones(Arrays.asList("8899999999"))
                    .build();
        }
    },
    CLIENTE_CADASTRADO_PROGRAMADA {
        @Override
        public OrderRequestCustomer pojo() {
            return OrderRequestCustomer.builder()
                    .name("Fabrícia Castanheira Jr.")
                    .email("salvador.goulart@testemarketplace.com.br")
                    .dateOfBirth("1995-01-01")
                    .gender("female")
                    .vatNumber("56082819772")
                    .phones(Arrays.asList("51999999999"))
                    .build();
        }
    },
    CLIENTE_NAO_CADASTRADO {
        @Override
        public OrderRequestCustomer pojo() {
            Name user = Cache.faker.name();
            return OrderRequestCustomer.builder()
                    .name(user.fullName())
                    .email(user.username() + "@testemarketplace.com.br")
                    .dateOfBirth("1995-01-01")
                    .gender("female")
                    .vatNumber(CPF.geraCPF())
                    .phones(Arrays.asList("51999999999"))
                    .build();
        }
    },
    CLIENTE_SIMPLES_PROGRAMADA {
        @Override
        public OrderRequestCustomer pojo() {
            return OrderRequestCustomer.builder()
                    .name("Helena Silveira")
                    .email("fernando.nascimento@testemarketplace.com.br")
                    .dateOfBirth("1995-01-01")
                    .gender("female")
                    .vatNumber("97224423920")
                    .phones(Arrays.asList("51999999999"))
                    .build();
        }
    },
    CLIENTE_SIMPLES_CORREIOS {
        @Override
        public OrderRequestCustomer pojo() {
            return OrderRequestCustomer.builder()
                    .name("Eduarda Gomes")
                    .email("luiz.mendes@testemarketplace.com.br")
                    .dateOfBirth("1995-01-01")
                    .gender("female")
                    .vatNumber("31382167814")
                    .phones(Arrays.asList("51999999999"))
                    .build();
        }
    };

    public abstract OrderRequestCustomer pojo();
}