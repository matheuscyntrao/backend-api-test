package model.timeB.phw31tst.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVendaRequestV1 {
    private BigInteger numeroPedido;
    private Integer codigoFilial;
    private Integer codigoUsuarioOperador;
    private Integer matriculaAtendente;
    private String dataAbertura;
    private Integer numeroCaixaDiario;
    private Integer sequenciaCaixaDiario;
}