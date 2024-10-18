package model.digital.panvelEcommerceBff.customer.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contacts {
    private Long communicationCode;
    private Long communicationCodeType;
    private Long contactCode;
    private String contactName;
    private String contactNumber;
    private Integer ddd;
    private Integer ddi;
    private String email;
    private String exclusionDate;
    private String lastUpdateTime;
    private String observation;
    private String preferential;
    private String telephoneExtension;
}
