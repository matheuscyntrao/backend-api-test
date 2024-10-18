package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PedidosPedidoResponse_v2_Endereco {
    private BigInteger codigoLocalidade;
    private BigInteger codigoLogradouro;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String referenciaEntrega;
    private String logradouro;
    private String tipoLogradouro;
    private String bairro;
    private BigInteger codigoMunicipioIBGE;
    private String municipio;
    private String uf;
    private String nomeUf;
    private BigInteger cep;
    private BigInteger codigoPais;
    private String siglaPais;
    private String nomePais;
}
