package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostClienteRequest_v2_Contato {
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

    public PostClienteRequest_v2_Contato generateClienteContato() {
        return PostClienteRequest_v2_Contato.builder()
                .codMeioComunicacao(13913508L)
                .codTipoComunicacao(4L)
                .ddd(0)
                .ddi(55)
                .descTipoComunicacao("E-MAIL")
                .email("teste@teste.com")
                .observacao("Teste QA")
                .build();
    }
}