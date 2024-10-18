package model.avengers.item.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetItensAtributos_v3Response {
    @NotNull
    private String nomeAtributo;
    private String valorAtributo;
}
