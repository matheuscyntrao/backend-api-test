package model.digital.entrega.v3.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetLockerConsultaByNumeroReserva {
    private Boolean isAtiva;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdAt;
    private String lockerNr;
    private String bookingNumber;
    private String status;
}
