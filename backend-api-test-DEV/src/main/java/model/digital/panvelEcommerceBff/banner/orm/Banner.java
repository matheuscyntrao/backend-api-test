package model.digital.panvelEcommerceBff.banner.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    private String image;
    private String link;
    private Long order;
}
