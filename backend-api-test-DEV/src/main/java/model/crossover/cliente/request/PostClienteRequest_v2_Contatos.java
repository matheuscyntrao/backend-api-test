package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostClienteRequest_v2_Contatos {
    private Long codMeioComunicacao;
    private Integer ddi;
    private Integer ddd;
    private String numero;
    private String ramal;
    private String email;
    private String observacao;
    private Long codTipoComunicacao;
    private String descTipoComunicacao;
    private String preferencial;

}
