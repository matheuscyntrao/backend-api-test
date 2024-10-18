package model.digital.entrega.v3.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetLockerConsultarReserva {
    private String nomeCliente;
    private Integer codigoCliente;
    private Integer pedido;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataDisponibilizaPedido;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataEfetivacaoPedido;
    private String situacaoPedido;
    private String pedidoAtrasado;
    private Integer filialTele;
    private String locker;
    private String nomeAmigavel;
    private Integer porta;
    private String reserva;
    private String sitRes;
    private String stLocker;
    private Integer cpf;
    private String senhaLocker;
    private Integer origemPedido;
    private String tipoPedido;
}
