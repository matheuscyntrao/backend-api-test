package model.avengers.mostruario.request;

import lombok.Data;

@Data
public class ItensListaRequest_v3 {
    private Integer filial;
    private String cep;
    private Integer perfil;
    private ItensListaRequest_v3_Convenio convenios[];
    private ItensListaRequest_v3_Item itens[];
    private Integer codConvenio;
    private ItensListaRequest_v3_ConsultaRegrasFiscais consultaRegrasFiscais;

}
