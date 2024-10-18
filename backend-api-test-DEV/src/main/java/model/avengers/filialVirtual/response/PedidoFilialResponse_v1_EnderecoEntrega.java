package model.avengers.filialVirtual.response;

import lombok.Data;

@Data
public class PedidoFilialResponse_v1_EnderecoEntrega {
    private Integer codigoLocalidade;
    private Integer codigoLogradouro;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String referenciaEntrega;
    private String logradouro;
    private String tipoLogradouro;
    private String bairro;
    private Integer codigoMunicipioIbge;
    private String municipio;
    private String uf;
    private String nomeUf;
    private String cep;
    private Integer codigoPais;
    private String siglaPais;
    private String nomePais;
}
