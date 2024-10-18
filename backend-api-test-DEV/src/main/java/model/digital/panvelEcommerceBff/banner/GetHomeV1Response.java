package model.digital.panvelEcommerceBff.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.banner.orm.Banner;
import model.digital.panvelEcommerceBff.banner.orm.LandPage;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetHomeV1Response {
    private List<Banner> banner;
    private List<LandPage> landPage;
}
