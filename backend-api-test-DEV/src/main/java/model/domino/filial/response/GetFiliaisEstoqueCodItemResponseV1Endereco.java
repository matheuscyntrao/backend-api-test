package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetFiliaisEstoqueCodItemResponseV1Endereco {
    private Double latitude;
    private Double longitude;
    private String tipoLogradouro;
    private String nomeLogradouro;
    private Integer numero;
    private String complemento;
    private Integer cep;
    private String cidade;
    private String bairro;
}
