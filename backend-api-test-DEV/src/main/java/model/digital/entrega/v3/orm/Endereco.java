package model.digital.entrega.v3.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
        private Integer codigoLocalidade;
        private Integer codigoLogradouro;
        private String tipoLogradouro;
        private String nomeLogradouro;
        private Integer numeroEndereco;
        private String complemento;
        private String nomeBairro;
        private String cep;
        private String nomeLocalidade;
        private String siglaUf;
        private String siglaPais;
}
