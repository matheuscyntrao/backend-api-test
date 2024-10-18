package model.avengers.mostruario.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ItensDetalheResponseV3ItemConvenio {
   private Integer codigo;
   private Integer filial;
   private String descricaoAbreviada;
   private Double percentualDesconto;
   @Valid
   private ItensDetalheResponseV3ItemConvenioAssociado associado;
   private Long codigoFilialPromotora;
   private Long codigoPromocao;
}
