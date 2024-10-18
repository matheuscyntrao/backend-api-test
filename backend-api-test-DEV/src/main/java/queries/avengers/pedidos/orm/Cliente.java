package queries.avengers.pedidos.orm;

import lombok.Data;
import model.avengers.pedido.response.orm.DadosFidelidade;
import model.digital.pedidosEcommerce.response.GetPedidosOrderidResponse_v1_Cliente_DadosFidelidade;

import java.math.BigInteger;

@Data
public class Cliente {

     private Integer codigoCliente;
     private String nome;
     private String ddd;
     private String telefone;
     private String ramal;
     private String cpf;
     private String cnpj;
     private String dddRastreio;
     private String telefoneRastreio;
     //private DadosFidelidade dadosFidelidade;
     private BigInteger codigoFilialConvenio;
     private BigInteger codigoConvenioFidelidade;
     private BigInteger codigoAssociadoFidelidade;
     private String matriculaFidelidade;
     private String email;
}
