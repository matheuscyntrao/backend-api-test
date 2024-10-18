package model.avengers.item.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetItensAutocompleteResponse_v2 {
    private BigInteger codigoItem;
    private String nomeDetalhado;
    private String nomenclaturaVarejo;
    private Boolean isPack;
}
