package model.digital.panvelEcommerceBff.category.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.campaign.response.orm.Banners;
import model.digital.panvelEcommerceBff.campaign.response.orm.LandPage;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetail {
    private List<Banners> banners;
    private LandPage landPage;
}
