package model.digital.pedidosEcommerce.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPedidoRequest_v1_Endereco {
    private Long codigoLocalidade;
    private Long codigoLogradouro;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String referenciaEntrega;
}
