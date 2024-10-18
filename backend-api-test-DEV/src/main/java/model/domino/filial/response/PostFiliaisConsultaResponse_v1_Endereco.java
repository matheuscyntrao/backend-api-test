package model.domino.filial.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostFiliaisConsultaResponse_v1_Endereco {
    private Long codigo;
    private Double latitude;
    private Double longitude;
    private String tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String siglaPais;
    private String siglaUf;
    private Long cep;
    private Long codLocalidade;
}
