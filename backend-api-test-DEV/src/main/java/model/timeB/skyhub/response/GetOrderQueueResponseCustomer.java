package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponseCustomer {
    @JsonProperty("vat_number")
    private String vatNumber;
    private List<String> phones;
    private String name;
    private String gender;
    private String email;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
}