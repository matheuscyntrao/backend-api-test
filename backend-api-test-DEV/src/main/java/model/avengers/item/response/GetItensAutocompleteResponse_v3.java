package model.avengers.item.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetItensAutocompleteResponse_v3 {
    private BigInteger itens[];
    private BigInteger packs[];
    private String sugestaoLista[];
}
