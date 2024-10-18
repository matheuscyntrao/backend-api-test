package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.domino.filial.response.GetFilialIdResponse_v1_Endereco;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary_Address {
    private String street;
    private String number;
    private String detail;
    private String neighborhood;
    private String city;
    private String region;
    private Integer post_code;
    private String reference;

    public Subsidiary_Address subsidiaryAddress2EnderecoFilial(GetFilialIdResponse_v1_Endereco filialIdResponseV1Endereco) {
        return Subsidiary_Address.builder()
                .street(filialIdResponseV1Endereco.getTipoLogradouro().concat(" ").concat(filialIdResponseV1Endereco.getNomeLogradouro()))
                .number(filialIdResponseV1Endereco.getNumero().toString())
                .detail(filialIdResponseV1Endereco.getComplemento())
                .neighborhood(filialIdResponseV1Endereco.getBairro())
                .city(filialIdResponseV1Endereco.getCidade())
                .region(filialIdResponseV1Endereco.getUf())
                .post_code(filialIdResponseV1Endereco.getCep())
                .reference("")
                .build();
    }
}
