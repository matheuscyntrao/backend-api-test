package entity.skyhub;

import lombok.Data;

import java.awt.*;

@Data
public class ProductsDeleteEntity {
    private Integer codigoItem;
    private String dataExclusao;
    private String itemBloqueado;
    private String itemAtivo;
    private String otc;
    private String hb;
}
