package model.domino.pucservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutWalletItemsRequest_v1 {
    private String channel;
    private PutWalletItemsRequest_v1_Client client;
    private PutWalletItemsRequest_v1_Item item;
    private Long subsidiary;
}
