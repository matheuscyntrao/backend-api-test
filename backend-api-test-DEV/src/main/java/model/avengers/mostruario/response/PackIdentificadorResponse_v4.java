package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class PackIdentificadorResponse_v4 {
    private Integer codigoPack;
    private String descricaoPack;
    private PackIdentificadorResponse_v4_Item itensPack[];
}
