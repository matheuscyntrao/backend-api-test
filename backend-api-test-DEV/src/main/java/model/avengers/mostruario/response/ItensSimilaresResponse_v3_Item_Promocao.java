package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class ItensSimilaresResponse_v3_Item_Promocao {
  private Integer codigoPromocao;
  private Integer codigoFilialPromotora;
  private Integer perfil;
  private Integer percentualDesconto;
  private String dataInicio;
  private String dataFinal;
  private String tipoPromocao;
  private String descricaoPromocao;
  private Integer codigoModalidade;
  private String descricaoModalidade;
}
