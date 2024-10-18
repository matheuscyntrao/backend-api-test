package model.digital.shippingService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesRequest_v1_Items_Groupers {
    private String code;
    private String type;

    public static PostDeliveriesRequest_v1_Items_Groupers generate() {
        return PostDeliveriesRequest_v1_Items_Groupers.builder()
                .code("123456")
                .type("PACK")
                .build();
    }

    public static List<PostDeliveriesRequest_v1_Items_Groupers> generateList() {
        PostDeliveriesRequest_v1_Items_Groupers[] list = new PostDeliveriesRequest_v1_Items_Groupers[1];
        list[0] = generate();
        return Arrays.asList(list.clone());
    }

}
