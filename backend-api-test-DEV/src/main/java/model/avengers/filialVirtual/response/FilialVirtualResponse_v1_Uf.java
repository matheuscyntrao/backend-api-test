package model.avengers.filialVirtual.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilialVirtualResponse_v1_Uf {
    private String pais;
    private String uf;
    private String nomeUf;
    private int codigoUfIbge;
}
