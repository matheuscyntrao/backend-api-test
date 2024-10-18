package model.digital.omniAlo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostAutenticacaoRequest_V1 {
    private String username;
    private String password;
}
