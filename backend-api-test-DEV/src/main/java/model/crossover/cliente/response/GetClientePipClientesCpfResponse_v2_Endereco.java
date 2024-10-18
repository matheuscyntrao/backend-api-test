package model.crossover.cliente.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetClientePipClientesCpfResponse_v2_Endereco {
    private Long codLogradouro;
    private Long codEntidadeComercial;
    private Integer seqEndEntidadeComercial;
    private String identificador;
    private Integer cep;
    private String logradouro;
    private String tipoLogradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Long codCidade;
    private String cidade;
    private String uf;
    private String referencia;
    private String preferencial;
    private Boolean indicadorResidencia;
    private List<GetClientePipClientesCpfResponse_v2_Endereco_TipoEndereco> tiposEndereco;
}
