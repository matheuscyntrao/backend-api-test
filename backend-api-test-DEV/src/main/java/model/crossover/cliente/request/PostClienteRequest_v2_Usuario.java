package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.PatternRegex;
import utils.service.Cache;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostClienteRequest_v2_Usuario {
    private String email;
    private String senha;

    public PostClienteRequest_v2_Usuario generateUsuario(){
        return PostClienteRequest_v2_Usuario.builder()
                .email(Cache.faker.bothify(PatternRegex.FAKER_EMAIL))
                .senha("102030")
                .build();
    }

}
