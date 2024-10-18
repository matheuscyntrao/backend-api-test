package model.digital.entrega.v3.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.entrega.orm.Item;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntregas {
    private Long filial;
    private Long cep;
    private String dataConsulta;
    private Integer perfil;
    private Integer operacao;
    private Long codCliente;
    private List<Item> itens;
    private Long codigoLogradouro;
    private Long numeroEndereco;
    private Boolean consultaCD;
    private String origemDesvioEstoque;
    private Integer logistica;
}
