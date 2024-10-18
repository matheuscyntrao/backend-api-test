package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class GetPedidosOrderidResponse_v1_Endereco {
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
