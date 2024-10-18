package model.avengers.mostruario.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItensDetalheRequest_v3_Item {
    private Integer codigo;
    private Boolean isPack;
    private Integer quantidade;

    public List<ItensDetalheRequest_v3_Item> createItens(Integer codigo) {
        return Arrays.asList(
                createItem(codigo)
        );
    }

    public ItensDetalheRequest_v3_Item createItem(Integer codigo) {
        return ItensDetalheRequest_v3_Item.builder()
                .codigo(codigo)
                .quantidade(1)
                .build();
    }
}
