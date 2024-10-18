package model.crossover.cliente.response;

import lombok.Data;

@Data
public class GetClientePipClientesCpfResponse_v2_Usuario {
    private String email;
    private String senha;
    private Boolean necessitaAlterarLoginDigital;
}
