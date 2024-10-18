package model.avengers.filialVirtual.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilialVirtualResponse_v1_Cidade {
    private int codigoLocalidade;
    private String nome;
    private String siglaUf;
    private String siglaPais;
    private int codigoMunicipio;
}
