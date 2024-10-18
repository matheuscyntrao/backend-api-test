package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidoRequest_v1_Item_Receita {
    private String numeroRegistro;
    private String siglaUf;
    private Integer tipoProfissional;
    private Integer codigoModeloReceita;
    private List<String> tipoCaptacao;
    private BigInteger numeroNotificacao;
    private String ufNotificacao;
    private String dataReceita;
    private PostPedidoRequest_v1_Item_Receita_Comprador comprador;
    private PostPedidoRequest_v1_Item_Receita_Paciente paciente;
    private PostPedidoRequest_v1_Item_Receita_Convenio convenio;
    private PostPedidoRequest_v1_Item_Receita_ReceitaEletronica receitaEletronica;
}
