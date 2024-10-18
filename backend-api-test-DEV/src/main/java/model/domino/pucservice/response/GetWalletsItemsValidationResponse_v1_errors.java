package model.domino.pucservice.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetWalletsItemsValidationResponse_v1_errors {
    private List<String> httpStatusCodes;
    private List<GetWalletsItemsValidationResponse_v1_errors_issues> issues;
    private List<String> suggestedApplicationActions;
    private List<String> suggestedUserActions;
    private String message;
    private String name;
    private String namespace;
}
