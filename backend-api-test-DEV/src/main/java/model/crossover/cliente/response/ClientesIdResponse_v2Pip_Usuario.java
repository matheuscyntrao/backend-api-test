package model.crossover.cliente.response;

import lombok.Data;

@Data
public class ClientesIdResponse_v2Pip_Usuario {
    private String email;
    private String senha;
    private Boolean necessitaAlterarLoginDigital;
}
