package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFidelidadeResponse_v1_Associados {
    private Long numeroCartao;
    private String adesaoFidelidade;
    private String bloqueado;
    private String numeroMatricula;
    private String cartaoDependente;
    private Boolean permiteCombinarFidelidade;
    private String errorMessenger;
    private BigInteger cpf;
    private BigInteger filialConvenio;
    private BigInteger codigoConvenio;
    private Long codigoConvenioDesconto;
    private BigInteger codigoConvenioAssociado;
    private Long tpConvenio;
    private String descricaoConvenio;
    private Boolean fidelidadeBloqueado;
    private String dataNascimento;
    private String clienteVip;
    private String dataEntregaRevista;
    private String dataMsgAniversario;
    private String pontosAniversario;
    private Integer qtdPontosMesAniversario;
    private String mensagemMesAniversario;
}

