package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class PrecosResponse_v3_DadosPack {
    private String tipoSelo;
    private String descricaoDetalhada;
    private Integer qtdItensVenda;
    private Integer qtdItensBrinde;
    private Boolean itensIguais;
    private String dataInicial;
    private String dataFinal;
}
