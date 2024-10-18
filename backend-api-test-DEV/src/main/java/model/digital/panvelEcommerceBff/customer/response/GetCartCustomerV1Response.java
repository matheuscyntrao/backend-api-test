package model.digital.panvelEcommerceBff.customer.response;

import lombok.Data;
import model.digital.panvelEcommerceBff.customer.response.orm.Contacts;
import model.digital.panvelEcommerceBff.cashPayment.response.orm.Address;

import java.util.List;

@Data
public class GetCartCustomerV1Response {
    private List<Address> address;
    private String alternativeEmail1;
    private String alternativeEmail2;
    private Long associateCode;
    private Long associateRegistry;
    private String civilStatus;
    private List<Contacts> contacts;
    private String cpf;
    private Long customerCode;
    private String customerType;
    private String dateOfBirth;
    private String email;
    private String gender;
    private String lastUpdateTime;
    private String name;
    private String orgaoEmissorRg;
    private String rg;
}
