package model.digital.entrega.v1_v2.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDestinatario {
    private Integer codigoLocalidade;
    private String siglaUf;
    private String siglaPais;
}
