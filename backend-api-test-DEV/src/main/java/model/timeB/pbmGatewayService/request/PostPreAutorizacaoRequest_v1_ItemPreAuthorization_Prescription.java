package model.timeB.pbmGatewayService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPreAutorizacaoRequest_v1_ItemPreAuthorization_Prescription {
    private Long codeProfessional;
    private String datePrescription;
    private String namePatient;
    private Long quantityPrescription;
    private String typeProfessional;
    private String ufProfessional;
}
