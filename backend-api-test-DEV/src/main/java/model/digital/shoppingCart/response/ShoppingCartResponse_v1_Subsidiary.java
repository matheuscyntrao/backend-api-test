package model.digital.shoppingCart.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.domino.filial.response.GetFilialIdResponse_v1;

import javax.validation.Valid;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponse_v1_Subsidiary {
    private String cnpj;
    private String subsidiaryId;
    private String subsidiaryName;
    private String friendlyName;
    private String phoneNumber;
    @Valid
    private ShoppingCartResponse_v1_Subsidiary_Address address;

    public static ShoppingCartResponse_v1_Subsidiary normalizarFilial(GetFilialIdResponse_v1 filial) {
        return ShoppingCartResponse_v1_Subsidiary.builder()
                .cnpj(filial.getCnpj())
                .subsidiaryId(filial.getFilial().toString())
                .subsidiaryName(filial.getNomeFilial())
                .friendlyName(filial.getNomeAmigavel())
                .phoneNumber(filial.getTelefone())
                .address(ShoppingCartResponse_v1_Subsidiary_Address.normalizarFilial(filial))
                .build();
    }
}
