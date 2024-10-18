package model.digital.entrega.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.v3.orm.Endereco;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetEntregaListarLock {
    private Integer idLocker;
    private Integer idModeloLocker;
    private Integer numeroLocker;
    private String nomeLocker;
    private String nomeAmigavelLocker;
    private LocalDateTime horarioInicial;
    private LocalDateTime horarioFinal;
    private LocalDateTime dataDesativacao;
    private Integer indicadorFuncionamento;
    private String latitude;
    private String longitude;
    private String filialAbastecimento;
    private Endereco endereco;
}
