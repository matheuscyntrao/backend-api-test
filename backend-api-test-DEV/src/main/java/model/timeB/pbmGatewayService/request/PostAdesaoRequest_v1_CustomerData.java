package model.timeB.pbmGatewayService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAdesaoRequest_v1_CustomerData {
    private Long serviceOrigin;
}
