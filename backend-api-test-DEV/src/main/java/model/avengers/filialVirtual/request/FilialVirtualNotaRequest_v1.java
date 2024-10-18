package model.avengers.filialVirtual.request;

import lombok.Data;

@Data
public class FilialVirtualNotaRequest_v1 {
    private Integer codigoFilial;
    private Integer codigoAtendente;
    private Integer codigoFuncionario;
    private Integer codigoUsuario;
    private Integer numeroPedido;
    private Boolean imprimeNfe;
}
