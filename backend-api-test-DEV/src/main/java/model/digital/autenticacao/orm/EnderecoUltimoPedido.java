package model.digital.autenticacao.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoUltimoPedido {
        private Integer codigoLocalidade;
        private Integer codigoLogradouro;
        private Integer numeroEndereco;
        private String complementoEndereco;
        private String logradouro;
        private String tipoLogradouro;
        private String bairro;
        private Integer codigoMunicipioIBGE;
        private String municipio;
        private String uf;
        private String nomeUf;
        private Integer cep;
        private Integer codigoPais;
        private String siglaPais;
        private String nomePais;
}
