package dataProvider.digital.shipping;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor(access = PROTECTED)
public enum EntregaTypeEnum {
    PROGRAMADA(0), RAPIDA(1), CORREIOS(0);
    private Integer value;
}
