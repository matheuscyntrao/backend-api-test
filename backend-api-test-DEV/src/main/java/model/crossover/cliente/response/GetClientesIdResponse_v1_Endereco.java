package model.crossover.cliente.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigInteger;

@Data
public class GetClientesIdResponse_v1_Endereco {
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
    @Valid
    private GetClientesIdResponse_v1_Endereco_TipoEndereco tiposEndereco[];
    private BigInteger codigoFilialUltimaAlteracao;
    private BigInteger codigoCanalUltimaAlteracao;

}
