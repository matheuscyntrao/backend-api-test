package model.crossover.cliente.response;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class GetClientesIdResponse_v1_Usuario {
    private String email;
    private String senha;
    private Boolean necessitaAlterarLoginDigital;
}
