package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.digital.omniAlo.request.PostAutenticacaoRequest_V1;

@Getter
@AllArgsConstructor
public enum PostAutenticacao {
    USUARIO_VALIDO {
        @Override
        public PostAutenticacaoRequest_V1 pojo() {
            return PostAutenticacaoRequest_V1.builder()
                    .username("rgarcia")
                    .password("teste123")
                    .build();
        }
    },
    USUARIO_EM_BRANCO {
        @Override
        public PostAutenticacaoRequest_V1 pojo() {
            return PostAutenticacaoRequest_V1.builder()
                    .username(null)
                    .password("teste123")
                    .build();
        }
    }, SENHA_EM_BRANCO {
        @Override
        public PostAutenticacaoRequest_V1 pojo() {
            return PostAutenticacaoRequest_V1.builder()
                    .username("rgarcia")
                    .password(null)
                    .build();
        }
    },
    SENHA_INVALIDA {
        @Override
        public PostAutenticacaoRequest_V1 pojo() {
            return PostAutenticacaoRequest_V1.builder()
                    .username("rgarcia")
                    .password("teste12322")
                    .build();
        }
    };

    public abstract PostAutenticacaoRequest_V1 pojo();
}
