package model.digital.panvelEcommerceBff.category.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.Filtros;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCategorySearchV1Request {
    private Long cep;
    private Long codigoCampanha;
    private List<Filtros> filtros;
    private Long numeroPagina;
    private String tipo;
    private Integer totalItensPagina;
    private String valueOrdenacao;
}
