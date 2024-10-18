package model.crossover.cliente.response;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class ClientesIdResponse_v2Pip_Endereco {
    private BigInteger codLogradouro;
    private BigInteger codEntidadeComercial;
    private Integer seqEndEntidadeComercial;
    private String identificador;
    private Integer cep;
    private String logradouro;
    private String tipoLogradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private BigInteger codCidade;
    private String cidade;
    private String uf;
    private String referencia;
    private String preferencial;
    private Boolean indicadorResidencia;
    private List<ClientesIdResponse_v2Pip_Endereco_TipoEndereco> tiposEndereco;
}
