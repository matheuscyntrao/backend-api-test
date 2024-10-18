package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class PackIdentificadorResponse_v3 {
    private Integer codigoPack;
    private String descricaoPack;
    private PackIdentificadorResponse_v3_Item itensPack[];
}
