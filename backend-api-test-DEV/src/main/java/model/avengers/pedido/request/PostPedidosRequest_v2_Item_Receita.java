package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PostPedidosRequest_v2_Item_Receita {
    private String numeroRegistro;
    private String siglaUf;
    private Integer tipoProfissional;
    private Integer codigoModeloReceita;
    private List<String> tipoCaptacao;
    private String numeroNotificacao;
    private String ufNotificacao;
    private String dataReceita;
    private BigInteger codigoFuncionario;
    private PostPedidosRequest_v2_Item_Receita_Comprador comprador;
    private PostPedidosRequest_v2_Item_Receita_Paciente paciente;
    private PostPedidosRequest_v2_Item_Receita_Convenio convenio;
    private String complementoNotificacao;
    private PostPedidosRequest_v2_Item_Receita_Eletronica receitaEletronica;
}
