package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CustomerResponse_v1_Contact {
    private BigInteger communicationCode;
    private BigInteger communicationCodeType;
    private BigInteger contactCode;
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
