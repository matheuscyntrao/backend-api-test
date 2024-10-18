package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPedido {

    INTERNET("I"),
    ALO_PANVEL("A"),
    FILIAL("F");

    private final String tipoPedido;

}