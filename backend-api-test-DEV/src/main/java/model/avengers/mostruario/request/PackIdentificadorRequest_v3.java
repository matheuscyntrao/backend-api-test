package model.avengers.mostruario.request;

import lombok.Data;

@Data
public class PackIdentificadorRequest_v3 {
    private Integer codigoFilial;
    private Integer perfilPack;
    private PackIdentificadorRequest_v3_Item itens[];
    private PackIdentificadorRequest_v3_Convenio convenios[];
}
