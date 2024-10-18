package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.avengers.mostruario.response.ItensDetalheResponseV3ItemCategoria;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategories {
    private String code;
    private String name;

    public List<ProductCategories> formatProductCategories(ItensDetalheResponseV3ItemCategoria[] itensDetalheResponseItemCategorias) {
        List<ProductCategories> productCategories = new ArrayList<>();
        ProductCategories category = new ProductCategories();
        List<String> categoryName = new ArrayList<>();
        List<String> categoryCode = new ArrayList<>();
        for (ItensDetalheResponseV3ItemCategoria itemCategoria : itensDetalheResponseItemCategorias) {
            categoryCode.add(itemCategoria.getId().toString());
            categoryName.add(itemCategoria.getDescricao());
        }
        category.setCode(String.join(".", categoryCode));
        category.setName(String.join(" > ", categoryName));
        productCategories.add(category);
        return productCategories;
    }
}