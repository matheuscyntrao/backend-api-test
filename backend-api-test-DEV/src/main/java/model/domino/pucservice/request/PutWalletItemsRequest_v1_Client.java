package model.domino.pucservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutWalletItemsRequest_v1_Client {
    private String birthDate;
    private String cellPhone;
    private Long clientCode;
    private String document;
    private String email;
    private String name;
}
