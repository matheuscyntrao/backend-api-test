package model.digital.panvelEcommerceBff.campaign.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banners {
    private String image;
    private String link;
    private Long order;
}
