package model.digital.campaign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCampaignResponse_v1 {
    private List<GetCampaignResponse_v1_Banner> banners;
    private GetCampaignResponse_v1_LandPage landPage;

}
