package model.crossover.cliente.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.service.Cache;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostClienteRequest_v2_Enderecos {
    private Long codEntidadeComercial;
    private Integer seqEndEntidadeComercial;
    private String identificador;
    private Integer cep;
    private Long codLogradouro;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private Long codCidade;
    private String cidade;
    private String uf;
    private String referencia;
    private String preferencial;
}
