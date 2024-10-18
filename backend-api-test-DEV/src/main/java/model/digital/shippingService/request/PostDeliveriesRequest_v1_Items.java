package model.digital.shippingService.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDeliveriesRequest_v1_Items {
    private Long code;
    private String codeEnum;
    private Boolean deliver;
    private List<PostDeliveriesRequest_v1_Items_Groupers> groupers;

    public static PostDeliveriesRequest_v1_Items generate() {
        return PostDeliveriesRequest_v1_Items.builder()
                .code(439250L)
                .deliver(true)
                .groupers(PostDeliveriesRequest_v1_Items_Groupers.generateList())
                .build();
    }

    public static List<PostDeliveriesRequest_v1_Items> generateList() {
        PostDeliveriesRequest_v1_Items[] itens = new PostDeliveriesRequest_v1_Items[1];
        itens[0] = generate();
        return Arrays.asList(itens.clone());
    }
}
