package model.avengers.mostruario.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class ItensPrincipioAtivoResponse_v3_item_DadosImagem {
    private BigInteger sequenciaImagem;
    private Integer numeroImagem;
    private String imagemPreferencial;
    private String url;
}
