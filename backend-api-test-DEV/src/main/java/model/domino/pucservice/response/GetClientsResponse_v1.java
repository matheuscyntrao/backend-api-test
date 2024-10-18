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
public class GetClientsResponse_v1 {
    private Long code;
    private String document;
    private String id;
    private List<String> programs;
    private String language;
    private String namespace;
    private List<GetWalletsItemsValidationResponse_v1_errors> errors;
}
