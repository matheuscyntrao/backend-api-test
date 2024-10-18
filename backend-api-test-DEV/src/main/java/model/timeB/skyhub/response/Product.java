package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import entity.marketplaceSeller.ProductEntity;
import entity.marketplaceSeller.ProductRuleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.avengers.mostruario.response.ItensDetalheResponseV3;
import model.avengers.mostruario.response.ItensDetalheResponseV3Item;
import model.avengers.mostruario.response.ItensDetalheResponseV3ItemDadosImagem;
import queries.timeB.marketplaceSeller.ProductQuerie;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"condition_type", "associations"})
public class Product {
    private String sku;
    private String name;
    private String description;
    private String status;
    private boolean removed;
    private Long qty;
    private BigDecimal price;
    @JsonProperty(value = "promotional_price")
    private BigDecimal promotionalPrice;
    private BigDecimal cost;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private String brand;
    private String ean;
    private String nbm;
    @Valid
    private List<ProductCategories> categories;
    @Valid
    private List<String> images;
    @Valid
    private List<ProductSpecifications> specifications;
    private Boolean errorAccess;

    public Product mostruario2Product(ItensDetalheResponseV3 mostruario, ProductEntity productEntity) {
        ProductRuleEntity productRuleEntity = ProductQuerie.getPriceRule();
        ProductCategories categories = new ProductCategories();
        ProductSpecifications specifications = new ProductSpecifications();

        return Product.builder()
                .sku(mostruario.getItens().get(0).getCodigo().toString())
                .name(mostruario.getItens().get(0).getNomenclaturaDetalhada())
                .description(productEntity.getDescDetalhadaMarketplace())
                .status("enabled")
                .removed(false)
                .qty(0L)
                .price(new BigDecimal(calculaPreco(productRuleEntity, mostruario).toString()))
                .promotionalPrice(mostruario.getItens().get(0).getPrecoPor())
                .cost(null) //TODO:Verificar
                .weight(productEntity.getWeight())
                .height(productEntity.getHeight())
                .width(productEntity.getWidth())
                .length(productEntity.getLength())
                .brand(mostruario.getItens().get(0).getDescricaoMarcaPai())
                .ean(mostruario.getItens().get(0).getEan().toString())
                .nbm("")
                .categories(categories.formatProductCategories(mostruario.getItens().get(0).getCategorias()))
                .images(formatProductImages(mostruario.getItens().get(0)))
                .specifications(specifications.formatSpecifications(mostruario.getItens().get(0), productEntity))
                .errorAccess(false)
                .build();
    }

    private Double calculaPreco(ProductRuleEntity productRuleEntity, ItensDetalheResponseV3 mostruario) {
        BigDecimal preco = productRuleEntity.getTipoPreco().equals("D") ? mostruario.getItens().get(0).getPrecoDe() : mostruario.getItens().get(0).getPrecoPor();
        AtomicReference<Double> precoFinal = new AtomicReference<>(Double.parseDouble(preco.toString()));
        precoFinal.set(precoFinal.get() + (precoFinal.get() * productRuleEntity.getPeAcresDescrPreco() / 100));
        return precoFinal.get();
    }

    public List<String> formatProductImages(ItensDetalheResponseV3Item item) {
        List<String> images = new ArrayList<>();
        ItensDetalheResponseV3ItemDadosImagem[] dadosImagem = item.getDadosImagens();
        for (ItensDetalheResponseV3ItemDadosImagem imagem : dadosImagem) {
            images.add(imagem.getUrl());
        }
        return images;
    }
}
