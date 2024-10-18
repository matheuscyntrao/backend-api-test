package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAutenticacaoResponse_v1 {
    @NotNull
    private String accessToken;
    @Pattern(regexp = "bearer")
    private String tokenType;
}
