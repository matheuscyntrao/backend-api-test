package entity.digital.shoppingCart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.math.BigDecimal;

@Data
@Entity("Shopping-Cart")
public class ShoppingCartEntity {
    @Id
    private ObjectId id;
    private String channel;
    private ShoppingCartEntity_Customer customer;
    private ShoppingCartEntity_Subsidiary subsidiaryEntity;
    private Boolean enable;
    private ShoppingCartEntity_Shipment shipments;
}

@Data
class ShoppingCartEntity_Customer {
    private Long customerCode;
    private String customerType;
    private String name;
}

@Data
class ShoppingCartEntity_Subsidiary {
    private String cnpj;
    private String subsidiaryId;
    private String subsidiaryName;
    private String friendlyName;
    private String phoneNumber;
    private ShoppingCartEntity_Subsidiary_Address subsidiaryAddress;
}

@Data
class ShoppingCartEntity_Subsidiary_Address {
    private Long localityCode;
    private Long streetCode;
    private Double latitude;
    private Double longitude;
    private String streetType;
    private String street;
    private Long number;
    private String complement;
    private String zipCode;
    private String city;
    private String neighborhood;
    private String state;
}

@Data
class ShoppingCartEntity_Shipment {

}

@Data
class ShoppingCartEntity_Item {
    private String code;
    private Long panvelCode;
    private Long ean;
    private BigDecimal originalPrice;
    private String productName;
    private Boolean psychotropic;
    private Boolean isBlockedInternet;
    private Long restrictions[];
    private Boolean containsPbm;
    private Boolean containsPack;
    private Boolean itemAssinavel;
    private ShoppingCartEntity_Item_Discount items[];
}

@Data
class ShoppingCartEntity_Item_Discount {
    private Double percentage;
    private BigDecimal dealPrice;
    private ShoppingCartEntity_Item_Discount_Detail discountDetail;
}

@Data
class ShoppingCartEntity_Item_Discount_Detail {
    private ShoppingCartEntity_Item_Discount_Detail_Promotion promotion;
}

@Data
class ShoppingCartEntity_Item_Discount_Detail_Promotion {
    private Long subsidiaryCode;
    private Long code;
}