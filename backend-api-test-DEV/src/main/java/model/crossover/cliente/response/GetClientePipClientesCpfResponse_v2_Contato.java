package model.crossover.cliente.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetClientePipClientesCpfResponse_v2_Contato {
    private Long codContato;
    private Long codEntidadeComercial;
    private Long codEntidadeComercialCont;
    private Long codMeioComunicacao;
    private Integer ddi;
    private Integer ddd;
    private String numero;
    private String ramal;
    private String email;
    private String observacao;
    private Long codTipoComunicacao;
    private String descTipoComunicacao;
    private String preferencial;
    private String contato;
    private String dataExclusao;
    private String dataAtualizacao;
    private String siteInternet;
    private String ftp;
}
