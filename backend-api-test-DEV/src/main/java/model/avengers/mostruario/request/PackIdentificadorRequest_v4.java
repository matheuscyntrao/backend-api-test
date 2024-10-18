package model.avengers.mostruario.request;

import lombok.Data;

@Data
public class PackIdentificadorRequest_v4 {
    private Integer codigoFilial;
    private Integer perfilPack;
    private PackIdentificadorRequest_v3_Item itens[];
}
