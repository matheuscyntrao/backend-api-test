package model.crossover.cliente.response;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.math.BigInteger;

@Data
public class GetClientesIdResponse_v1_Contato {
    private BigInteger codContato;
    private BigInteger codEntidadeComercial;
    private BigInteger codEntidadeComercialCont;
    private BigInteger codMeioComunicacao;
    private Integer ddi;
    private Integer ddd;
    private String numero;
    private String ramal;
    private String email;
    private String observacao;
    private BigInteger codTipoComunicacao;
    private String descTipoComunicacao;
    private String preferencial;
    private String contato;
    private String dataExclusao;
    private String dataAtualizacao;
    private String siteInternet;
    private String ftp;
}