package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private Integer codLogradouro;
    private Integer codEntidadeComercial;
    private Integer seqEndEntidadeComercial;
    private Integer cep;
    private String logradouro;
    private String tipoLogradouro;
    private Integer numero;
    private String bairro;
    private Integer codCidade;
    private String cidade;
    private String uf;
    private List<TipoEndereco> tiposEndereco;
}
