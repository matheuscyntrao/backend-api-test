package model.avengers.filialVirtual.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilialVirtualResponse_v1_Bairro {
    private String descricao;
    private int codigoLocalidade;
    private int codigoBairro;
}
