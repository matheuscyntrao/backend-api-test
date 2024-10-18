package model.digital.category.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategoryResponse_v1_Banner {
    private String urlImage;
    private String linkImage;
}
