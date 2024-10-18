package model.digital.entrega.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetLockerStatusByLockerName {
    private Boolean statusLocker;
    private String maiorPorta;
}
