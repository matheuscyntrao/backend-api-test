package model.domino.convenio.request;

import lombok.Data;

@Data
public class ConvenioBaixarSaldoRequest_v2 {
    private Integer filial;
    private Integer filialConvenio;
    private Integer convenio;
    private Integer associado;
    private String matricula;
    private Integer valorVenda;
    private String tipoTransacao;
}
