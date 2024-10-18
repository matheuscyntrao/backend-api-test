package model.crossover.clienteVarejo.response;

import lombok.Data;

@Data
public class GetClienteVarejoClientesOptInsResponse {

    private String cpf;
    private Boolean push;
    private Boolean sms;
    private Boolean call;
    private Boolean email;
    private Boolean requestOptin;


}
