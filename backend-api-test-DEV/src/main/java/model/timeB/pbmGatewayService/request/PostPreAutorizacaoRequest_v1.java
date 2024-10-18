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
public class PostPreAutorizacaoRequest_v1 {
    private String cardBeneficiary;
    private Integer channel;
    private String channelOrigin;
    private String codeProgram;
    private Integer codeSubsidiary;
    private String cpfAttendance;
    private String cpfBeneficiary;
    private String identifierTransaction;
    private List<PostPreAutorizacaoRequest_v1_ItemPreAuthorization> itemPreAuthorization;
    private String numberSession;
    private Long sequenceProgram;
    private String station;
    private String typeProgram;
    private String user;
}
