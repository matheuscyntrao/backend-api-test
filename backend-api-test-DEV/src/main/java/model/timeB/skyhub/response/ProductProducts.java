package model.timeB.skyhub.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties({"total", "next"})
public class ProductProducts {
    private List<Product> products;
    private Integer total;
    private String next;
}


