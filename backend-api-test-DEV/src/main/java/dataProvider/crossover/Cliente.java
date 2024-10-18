package dataProvider.crossover;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.crossover.cliente.request.PostClienteRequest_v2;
import model.crossover.cliente.request.PostClienteRequest_v2_Usuario;
import utils.CPF;
import utils.service.Cache;

@Getter
@AllArgsConstructor
public enum Cliente {
    CLIENTE_SIMPLES {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPF())
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    },
    CLIENTE_COMPLETO {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPF())
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_1 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("1"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_2 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("2"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_3 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("3"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_4 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("4"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_5 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("5"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_6 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("6"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_7 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("7"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_8 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("8"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_9 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("9"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    }, CLIENTE_CLEARSALE_0 {
        @Override
        public PostClienteRequest_v2 pojo() {
            return PostClienteRequest_v2.builder()
                    .cpf(CPF.geraCPFComSufixo("0"))
                    .nome(Cache.faker.name().firstName().concat(" ").concat(Cache.faker.name().lastName()))
                    .receberNewsletter("N")
                    .usuario(new PostClienteRequest_v2_Usuario().generateUsuario())
                    .build();
        }
    };

    public abstract PostClienteRequest_v2 pojo();
}
