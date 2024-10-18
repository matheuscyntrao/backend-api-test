package model.domino.convenio.response;

import lombok.Data;

@Data
public class ConvenioResponse_v2 {
    private Integer codigofilialMatriz;
    private Integer codigo;
    private Integer codigoCliente;
    private String descricao;
    private Integer numeroDeVias;
    private Boolean possuiAssociado;
    private Integer tipoComprovante;
    private Integer tipoConfissaoDivida;
    private ConvenioResponse_v2_PagamentoConvenio pagamentoConvenio;
    private Boolean utilizaTefDesabilitado;
}
