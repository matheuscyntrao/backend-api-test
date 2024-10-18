package model.digital.panvelEcommerceBff.category.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import model.digital.panvelEcommerceBff.campaign.response.orm.FiltersList;
import model.digital.panvelEcommerceBff.category.response.orm.CategoryDetail;

import java.util.List;

@Data
public class PostCategorySearchV1Response {
    private CategoryDetail categoryDetail;
    @JsonProperty("filters")
    private List<FiltersList> filtersList;
    private List<Long> itens;
    private Long totalItens;
}
