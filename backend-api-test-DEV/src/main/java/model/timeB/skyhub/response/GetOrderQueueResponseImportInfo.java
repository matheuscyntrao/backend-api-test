package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponseImportInfo {
    @JsonProperty("ss_name")
    private String ssName;
    @JsonProperty("remote_id")
    private String remoteId;
    @JsonProperty("remote_code")
    private String remoteCode;
    @JsonProperty("cart_id")
    private Integer cartID;
}