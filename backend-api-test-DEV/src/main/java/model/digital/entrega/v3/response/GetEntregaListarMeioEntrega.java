package model.digital.entrega.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.v3.orm.Link;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEntregaListarMeioEntrega {
    private Integer codigoMeioEntrega;
    private String descricaoMeioEntrega;
    private List<Link> links;
}
