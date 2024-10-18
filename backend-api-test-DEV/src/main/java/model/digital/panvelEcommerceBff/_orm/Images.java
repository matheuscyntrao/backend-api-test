package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    private Long sequence;
    private Long number;
    private Boolean preferredImage;
    private String url;
}
