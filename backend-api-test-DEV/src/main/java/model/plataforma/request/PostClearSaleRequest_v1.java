package model.plataforma.request;

import lombok.Data;

@Data
public class PostClearSaleRequest_v1 {
    private String code;
    private String date;
    private String type;
}
