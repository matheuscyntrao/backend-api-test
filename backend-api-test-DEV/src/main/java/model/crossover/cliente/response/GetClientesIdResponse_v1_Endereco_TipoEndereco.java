package model.crossover.cliente.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigInteger;

@Data
public class GetClientesIdResponse_v1_Endereco_TipoEndereco {
    @JsonProperty("Código do tipo do endereço")
    private BigInteger codigo;
    private String descricao;

}
