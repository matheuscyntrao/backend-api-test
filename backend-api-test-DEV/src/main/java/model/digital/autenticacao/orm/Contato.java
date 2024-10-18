package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    private Integer codMeioComunicacao;
    private String email;
    private String observacao;
    private Integer codTipoComunicacao;
    private String descTipoComunicacao;
    private LocalDateTime dataAtualizacao;
}
