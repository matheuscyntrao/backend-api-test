package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFilialResponse_v1 {
    private String nomeAmigavel;
    private String nome;
    @Pattern(regexp = "\\d{14}")
    private String cnpj;
    private Boolean panvelGo;
    private GetFilialResponse_v1_Entrega entrega;
    private Long codigoFilial;
    private Boolean checkoutOmni;
    private String origemDesvioEstoque;
    private List<Integer> filiaisDeApoio;
    private String dataEntregaCD;
    private Integer logistica;
}

