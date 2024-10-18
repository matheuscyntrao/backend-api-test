package entity.digital.shoppingCart;

import lombok.Data;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;

@Entity("Customer")
@Data
public class CustomerEntity {
    @Id
    private Long id;
    private String customerType;
    private String name;
    private String cpf;
    private Instant dateOfBirth;
    private String gender;
    private String civilStatus;
    private Instant lastUpdateTime;
    private CustomerEntity_Contact contacts[];
    private CustomerEntity_Address addresses[];
    private String email;
}

@Data
class CustomerEntity_Contact {
    private Long communicationCode;
    private Integer ddi;
    private Integer ddd;
    private String contactNumber;
    private String communicationCodeType;
    private Instant lastUpdateTime;
}

@Data
class CustomerEntity_Address {
    private Long streetCode;
    private Long addressCode;
    private String zipCode;
    private String street;
    private String streetType;
    private Long addressNumber;
    private String neighborhood;
    private Long cityCode;
    private String city;
    private String state;
}