package model.avengers.mostruario.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItensDetalheRequest_v3_Convenio {
    private Integer codigoConvenio;
    private String matricula;
    private Integer codigoDependente;

    public List<ItensDetalheRequest_v3_Convenio> createConvenios() {
        ItensDetalheRequest_v3_Convenio[] convenios = new ItensDetalheRequest_v3_Convenio[1];
        convenios[0] = createConvenio();
        return Arrays.asList(convenios);
    }

    public ItensDetalheRequest_v3_Convenio createConvenio(){
        return ItensDetalheRequest_v3_Convenio.builder()
                .codigoConvenio(416061)
                .build();
    }
}

