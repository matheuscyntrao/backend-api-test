package model.plataforma.request;

import lombok.Data;

@Data
public class PostKondutoRequest_v1 {
    private String order_id;
    private Long timestamp;
    private String status;
    private String signature;
}
