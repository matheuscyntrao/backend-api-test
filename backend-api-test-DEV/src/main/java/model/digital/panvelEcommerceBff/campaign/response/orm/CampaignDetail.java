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
public class CampaignDetail {
    private List<Banners> banners;
    private LandPage landPage;
}
