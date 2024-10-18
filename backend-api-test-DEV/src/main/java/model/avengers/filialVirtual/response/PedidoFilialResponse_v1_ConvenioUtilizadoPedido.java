package model.avengers.filialVirtual.response;

import lombok.Data;

@Data
public class PedidoFilialResponse_v1_ConvenioUtilizadoPedido {
    private Integer codigoFilialConvenio;
    private Integer codigoConvenio;
    private Integer sequenciaConvenioPedido;
    private String matriculaAssociado;
    private String numeroIin;
    private String numeroDoCartao;
    private Boolean trocaSacolaPonto;
    private String cpf;
}
