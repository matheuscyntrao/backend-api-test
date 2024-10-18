package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrigemPedido {

    M_COMMERCE(1),
    ALO_PANVEL(2),
    E_COMMERCE(3),
    RESTAGE_MULTIPLUS(4),
    APP(5),
    MARKETPLACE(6),
    FILIAL(7);

    private final Integer origemPedido;

}
