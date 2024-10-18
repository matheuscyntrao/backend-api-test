package model.domino.filial.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetFilialIdResponse_v1_Endereco {
    private Integer codigoLocalidade;
    private Integer codigoBairro;
    private Integer codigoLogradouro;
    private Double latitude;
    private Double longitude;
    private Integer sequenciaEndereco;
    private String tipoLogradouro;
    private String nomeLogradouro;
    private Integer numero;
    private String complemento;
    private Integer cep;
    private String cidade;
    private String bairro;
    private String uf;
}
