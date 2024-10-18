package model.digital.campaign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCampaignResponse_v1_Banner {
    private String urlImage;
    private String linkImage;
}
