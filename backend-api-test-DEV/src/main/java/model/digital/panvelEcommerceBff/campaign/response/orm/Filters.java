package model.digital.panvelEcommerceBff.campaign.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Filters {
    private Long campaignLink;
    private Long categoryId;
    private String name;
    private Long order;
    private Long quantity;
}
