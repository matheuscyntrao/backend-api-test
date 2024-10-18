package model.digital.shoppingCart.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.domino.filial.response.GetFilialIdResponse_v1;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponse_v1_Subsidiary_Address {
    private Integer localityCode;
    private Integer streetCode;
    private Double latitude;
    private Double longitude;
    private String streetType;
    private String street;
    private Integer number;
    private String complement;
    private String zipCode;
    private String city;
    private String neighborhood;
    private String state;

    public static ShoppingCartResponse_v1_Subsidiary_Address normalizarFilial(GetFilialIdResponse_v1 filial) {
        return ShoppingCartResponse_v1_Subsidiary_Address.builder()
                .localityCode(filial.getEndereco().getCodigoLocalidade())
                .streetCode(filial.getEndereco().getCodigoLogradouro())
                .latitude(filial.getEndereco().getLatitude())
                .longitude(filial.getEndereco().getLongitude())
                .streetType(filial.getEndereco().getTipoLogradouro())
                .street(filial.getEndereco().getNomeLogradouro())
                .number(filial.getEndereco().getNumero())
                .complement(filial.getEndereco().getComplemento())
                .zipCode(filial.getEndereco().getCep().toString())
                .city(filial.getEndereco().getCidade())
                .neighborhood(filial.getEndereco().getBairro())
                .state(filial.getEndereco().getUf())
                .build();
    }
}
