package model.timeB.skyhub.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestCustomer {
    private String name;
    private String email;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    private String gender;
    @JsonProperty("vat_number")
    private String vatNumber;
    private List<String> phones;
}