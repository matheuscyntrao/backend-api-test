package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class ItensGenericoResponse_v3 {
   private ItensPrincipioAtivoResponse_v3_item itens[];
   private ItensPrincipioAtivo_v3_Pack packs[];
}