package model.digital.entrega.v3.request;

import lombok.Data;
import model.digital.entrega.orm.Item;

import java.util.List;

@Data
public class PostCorreiosRequest {
    private Integer cepOrigem;
    private Integer cepEntrega;
    private List<Item> itens;
}
