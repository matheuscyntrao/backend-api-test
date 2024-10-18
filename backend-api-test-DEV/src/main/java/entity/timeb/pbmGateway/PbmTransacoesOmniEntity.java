package entity.timeb.pbmGateway;

import lombok.Data;

@Data
public class PbmTransacoesOmniEntity {
    private String transactionIdentify;
    private Integer codigoCanalVenda;
    private String tipoPrograma;
    private String codigoAdminConvenios;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private String usuarioTransacao;
    private String origem;
}
