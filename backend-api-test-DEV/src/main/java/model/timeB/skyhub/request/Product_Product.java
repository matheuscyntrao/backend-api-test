package model.timeB.skyhub.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.timeB.skyhub.response.Product;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product_Product {
    private Product product;
}
