package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entity.marketplaceSeller.SubsidiaryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.domino.filial.response.GetFilialIdResponse_v1;
import queries.timeB.marketplaceSeller.SubsidiaryQuerie;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties({"statuses"})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary {
    private String code;
    private String name;
    private String open_hours;
    private String phone;
    private String email;
    private Double latitude;
    private Double longitude;
    private Double max_delivery_distance;
    @Valid
    private Subsidiary_Address address;
    @Valid
    private Subsidiary_Schedules schedules;
    private List<String> properties;

    public Subsidiary filial2subsidiary(GetFilialIdResponse_v1 filial) {
        String abertura = formatBusinessHours(filial.getHorarioAbertura());
        String fechamento = formatBusinessHours(filial.getHorarioFechamento());

        return Subsidiary.builder()
                .code(filial.getFilial().toString())
                .name(filial.getNomeAmigavel())
                .open_hours(formatOpenHours(abertura, fechamento))
                .phone(filial.getTelefone())
                .email(formatEmail(filial.getFilial()))
                .latitude(filial.getEndereco().getLatitude())
                .longitude(filial.getEndereco().getLongitude())
                .max_delivery_distance(2.0)
                .address(new Subsidiary_Address().subsidiaryAddress2EnderecoFilial(filial.getEndereco()))
                .schedules(new Subsidiary_Schedules().formatWeekDays(abertura, fechamento))
                .properties(formatProperties(filial.getFilial()))
                .build();
    }

    //TODO validar a origem do campo max_delivery_distance

    public String formatOpenHours(String start, String end) {
        return start + " às " + end;
    }

    public String formatBusinessHours(Integer hour) {
        String hora = hour.toString();
        if (hora.length() > 3) {
            return hora.substring(0, 2) + ":" + hora.substring(2, 4);
        } else if (hora.length() == 3) {
            return hora.substring(0, 1) + ":" + hora.substring(1, 3);
        }
        return "00:00";
    }

    public List<String> formatProperties(Integer filial) {
        List<String> properties = new ArrayList<>();
        SubsidiaryEntity subsidiaryQuerie = SubsidiaryQuerie.getSubsidiaryDetail(filial.toString());
        if (subsidiaryQuerie.getConfirmaEstoque().equals("S")) {
            properties.add(Subsidiary_Properties_Enum.CONFIRM_STOCK.getProperty());
        }
        if (subsidiaryQuerie.getExpedeMercadoria().equals("S")) {
            properties.add(Subsidiary_Properties_Enum.EXPEDITION.getProperty());
        }
        return properties;
    }

    public String formatEmail(Integer codigoFilial) {
        return "PV".concat(String.format("%03d", codigoFilial)).concat("@panvel.com.br");
    }
}
