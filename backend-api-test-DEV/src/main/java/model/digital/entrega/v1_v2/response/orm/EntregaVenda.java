package model.digital.entrega.v1_v2.response.orm;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EntregaVenda {

    private Filial filial;
    private String forma;
    private String entregaMotoboy;
    private Integer minimoPedido;
    private Integer prazo;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime proximaAbertura;

    private RotaEntrega rotaEntrega;
    private String status;
    private BigDecimal valorEntrega;
    private EnderecoDestinatario enderecoDestinatario;

}
