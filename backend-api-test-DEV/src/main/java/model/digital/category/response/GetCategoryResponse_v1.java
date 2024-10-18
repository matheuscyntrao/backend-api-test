package model.digital.category.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCategoryResponse_v1 {
    private Long id;
    private String name;
    private List<GetCategoryResponse_v1_Banner> banners;
    private GetCategoryResponse_v1_LandPage landPage;

}
