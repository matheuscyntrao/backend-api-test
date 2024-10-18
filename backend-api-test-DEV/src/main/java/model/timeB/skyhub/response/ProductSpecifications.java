package model.timeB.skyhub.response;

import entity.marketplaceSeller.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.avengers.mostruario.response.ItensDetalheResponseV3Item;

import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecifications {
    private String key;
    private String value;

    public List<ProductSpecifications> formatSpecifications(ItensDetalheResponseV3Item item, ProductEntity product) {
        return Arrays.asList(
                ProductSpecifications.builder()
                        .key("Codigo")
                        .value(item.getCodigo().toString())
                        .build(),
                ProductSpecifications.builder()
                        .key("Código de barras")
                        .value(item.getEan().toString())
                        .build(),
                ProductSpecifications.builder()
                        .key("Dimensões")
                        .value(product.getHeight().toString()
                                .concat("x")
                                .concat(product.getWidth().toString())
                                .concat("x")
                                .concat(product.getLength().toString()))
                        .build(),
                ProductSpecifications.builder()
                        .key("Marca/Fabricante")
                        .value(item.getDescricaoMarcaPai())
                        .build(),
                ProductSpecifications.builder()
                        .key("Peso")
                        .value(product.getWeight().toString())
                        .build()
        );
    }
}
