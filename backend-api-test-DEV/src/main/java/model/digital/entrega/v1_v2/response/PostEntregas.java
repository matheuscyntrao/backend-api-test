package model.digital.entrega.v1_v2.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.orm.Item;
import model.digital.entrega.v1_v2.response.orm.HorarioRota;
import model.digital.entrega.v1_v2.response.orm.ItemBrinde;
import model.digital.entrega.v1_v2.response.orm.ItemVenda;
import model.digital.entrega.v1_v2.response.orm.Pack;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntregas {
    private Integer codigo;
    private Integer filial;
    private BigDecimal custo;
    private String tipoDeEntrega;
    private Integer prazoInicial;
    private Integer prazoFinal;
    private String unidadePrazoEntrega;
    private String nome;
    private Boolean freteGratis;
    private List<Item> itemList;
    private List<Pack> packList;
    private List<ItemVenda> itemVendaList;
    private List<ItemBrinde> itemBrindesList;
    private LocalDateTime horarioAberturaFilial;
    private HorarioRota horarioRota;
    private BigDecimal valorFaltantefreteGratis;
}
