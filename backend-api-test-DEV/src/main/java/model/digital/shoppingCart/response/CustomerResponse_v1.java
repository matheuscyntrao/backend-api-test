package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigInteger;

@Data
public class CustomerResponse_v1 {
    @Valid
    private CustomerResponse_v1_Address addresses[];
    private String alternativeEmail1;
    private String alternativeEmail2;
    private BigInteger associateCode;
    private BigInteger associateRegistry;
    private String civilStatus;
    @Valid
    private CustomerResponse_v1_Contact contacts[];
    private String cpf;
    private BigInteger customerCode;
    private String customerType;
    private String dateOfBirth;
    private String email;
    private String gender;
    private String lastUpdateTime;
    private String name;
    private String orgaoEmissorRg;
    private String rg;
}
