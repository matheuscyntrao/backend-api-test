package model.digital.entrega.v3.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.v3.orm.Cliente;
import model.digital.entrega.v3.orm.ItemQuantidade;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLockerReservar {
    private Integer pedido;
    private String nomeLocker;
    private List<ItemQuantidade> itemQuantidadeList;
    private Cliente cliente;
}
