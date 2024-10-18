package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties({"total", "next"})
public class Subsidiary_Stores {
    private List<Subsidiary> stores;
    private Integer total;
    private String next;
}
