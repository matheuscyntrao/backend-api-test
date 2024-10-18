package entity.digital.authentication;

import lombok.Data;

@Data
public class UsuarioLoginEntity {
    private String  codigo;
    private String usuario;
    private String senha;
    private String isBloqueado;
    private String isLiberado;
}
