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
public class GetWalletsItemsValidationResponse_v1_errors_issues {
    private String errorCode;
    private String id;
    private String issue;
}
