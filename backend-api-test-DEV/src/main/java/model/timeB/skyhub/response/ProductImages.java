package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImages {
    private String urlImage;

    public ProductImages productImagesBuilder(String url){
        return ProductImages.builder()
                .urlImage(url)
                .build();
    }

}