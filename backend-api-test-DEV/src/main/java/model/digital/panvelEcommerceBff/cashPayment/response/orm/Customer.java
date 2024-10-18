package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String alternativeEmail1;
    private String alternativeEmail2;
    private Long associateCode;
    private Long associateRegistry;
    private String civilStatus;
    private String cpf;
    private Long customerCode;
    private String customerType;
    private String dateOfBirth;
    private DeliveryAddress deliveryAddress;
    private DeliveryContact deliveryContact;
    private String email;
    private String gender;
    private String lastUpdateTime;
    private String name;
    private String orgaoEmissorRg;
    private String rg;
}
