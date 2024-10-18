package model.digital.entrega.v1_v2.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.orm.Item;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntregas {
    private Integer cep;
    private Integer codFilial;
    private Integer perfil;
    private List<Item> itemList;
    private Integer codCliente;
    private String filtroFormaEntregaEnum; // TODO
    private Boolean filtroFormaEntregaInformado;
}
