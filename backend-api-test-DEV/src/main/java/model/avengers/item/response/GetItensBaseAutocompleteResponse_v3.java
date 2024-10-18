package model.avengers.item.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GetItensBaseAutocompleteResponse_v3 {
    private BigInteger codigoItem;
    private String nomenclaturaVarejo;
    private Boolean isPack;
    private String nomeDetalhado;
    private Boolean possuiItemAVencer;
    private Boolean participaPbm;
    private Boolean participaNovoPack;
    private Boolean permiteAdesao;
    private Boolean possuiKitAdesao;
    private Boolean exclusivoPanvel;
    private Boolean participaListaReferencial;
    private Boolean participaFarmaciaPopular;
}
