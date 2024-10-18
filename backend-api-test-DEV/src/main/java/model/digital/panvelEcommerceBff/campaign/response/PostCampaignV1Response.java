package model.digital.panvelEcommerceBff.campaign.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.campaign.response.orm.CampaignDetail;
import model.digital.panvelEcommerceBff.campaign.response.orm.FiltersList;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCampaignV1Response {
    private CampaignDetail campaignDetail;
    @JsonProperty("filters")
    private List<FiltersList> filtersList;
    private List<Long> itens;
    private Long totalItens;
}
