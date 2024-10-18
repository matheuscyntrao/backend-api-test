package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFidelidadeResponse_v1 {
    private String nomeAssociado;
    private BigInteger cpf;
    private String messengerError;
    private GetFidelidadeResponse_v1_Associados associados;
}

