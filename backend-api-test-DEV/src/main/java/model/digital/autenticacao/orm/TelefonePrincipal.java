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
public class TelefonePrincipal {
    private Integer codMeioComunicacao;
    private Integer ddi;
    private Integer ddd;
    private String numero;
    private Integer codTipoComunicacao;
    private String descTipoComunicacao;
    private LocalDateTime dataAtualizacao;
}