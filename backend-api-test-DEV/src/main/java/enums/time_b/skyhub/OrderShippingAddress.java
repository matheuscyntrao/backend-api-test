package enums.time_b.skyhub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.skyhub.request.OrderRequestShippingAddress;

@AllArgsConstructor
@Getter
public enum OrderShippingAddress {
    ENDERECOENTREGA_SIMPLES {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("alberto bins")
                    .number(1624)
                    .detail("Ponto de referência teste")
                    .neighborhood("CENTRO")
                    .city("ELDORADO DO SUL")
                    .region("RS")
                    .country("BR")
                    .postcode("90030140")
                    .build();
        }
    },
    ENDERECOENTREGA_PROGRAMADA {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Rua Joaquim Caetano da Silva")
                    .number(1624)
                    .detail("Ponto de referência teste")
                    .neighborhood("MOINHOS DE VENTO")
                    .city("PORTO ALEGRE")
                    .region("RS")
                    .country("BR")
                    .postcode("90570130")
                    .build();
        }
    },
    ENDERECOENTREGA_CORREIOS {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Praça da Bandeira")
                    .number(1624)
                    .detail("Ponto de referência teste")
                    .neighborhood("CENTRO")
                    .city("SÃO PAULO")
                    .region("SP")
                    .country("BR")
                    .postcode("01007020")
                    .build();
        }
    },
    ENDERECOENTREGA_LOCALIDADE {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("INDUSTRIAL BELGRAF")
                    .number(865)
                    .detail("Dimed")
                    .neighborhood("INDUSTRIAL")
                    .city("ELDORADO DO SUL")
                    .region("RS")
                    .country("BR")
                    .postcode("92990000")
                    .build();
        }
    },
    ENDERECOENTREGA_SEM_MATCH {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("TESTE SEM MATCH FONETICO")
                    .number(1624)
                    .detail("Ponto de referência teste")
                    .neighborhood("CENTRO")
                    .city("ELDORADO DO SUL")
                    .region("RS")
                    .country("BR")
                    .postcode("92990000")
                    .build();
        }
    },
    ENDERECOENTREGA_PROGRAMADA_NOVO {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Avenida Doutor Nilo Peçanha")
                    .number(1121)
                    .detail("Ponto de referência teste")
                    .neighborhood("TRÊS FIGUEIRAS")
                    .city("PORTO ALEGRE")
                    .region("RS")
                    .country("BR")
                    .postcode("91330000")
                    .build();
        }
    },
    ENDERECOENTREGA_CORREIOS_PAC {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Rua Uruguaiana")
                    .number(80)
                    .detail("Ponto de referência teste")
                    .neighborhood("CENTRO")
                    .city("RIO DE JANEIRO")
                    .region("RJ")
                    .country("BR")
                    .postcode("20050091")
                    .build();
        }
    },
    ENDERECOENTREGA_CORREIOS_SEDEX {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Rua Capitão Coelho (Ilha da Pintada)")
                    .number(250)
                    .detail("Ponto de referência teste")
                    .neighborhood("ARQUIPÉLAGO")
                    .city("PORTO ALEGRE")
                    .region("RS")
                    .country("BR")
                    .postcode("90090040")
                    .build();
        }
    },
    ENDERECOENTREGA_TESTE {
        @Override
        public OrderRequestShippingAddress pojo() {
            return OrderRequestShippingAddress.builder()
                    .street("Rua Indianápolis")
                    .number(240)
                    .detail("Próximo ao TESTE")
                    .neighborhood("TRÊS FIGUEIRAS")
                    .city("PORTO ALEGRE")
                    .region("RS")
                    .country("BR")
                    .postcode("91330060")
                    .build();
        }
    };

    public abstract OrderRequestShippingAddress pojo();
}