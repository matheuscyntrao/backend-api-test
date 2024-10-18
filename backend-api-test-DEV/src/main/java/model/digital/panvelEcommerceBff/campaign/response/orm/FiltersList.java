package model.digital.panvelEcommerceBff.campaign.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FiltersList {
    private List<Filters> filters;
    private String label;
    private String name;
    private Long order;
    private String type;
}
