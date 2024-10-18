package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cep {

    CEP_RAPIDA_PROGRAMADA_PAC(88053135),
    CEP_RAPIDA_PROGRAMADA(92500000),
    CEP_RAPIDA(90200274),
    CEP_PAC(35260000);

    private final Integer cep;

}
