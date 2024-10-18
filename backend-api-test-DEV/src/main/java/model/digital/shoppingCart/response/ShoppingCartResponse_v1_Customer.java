package model.digital.shoppingCart.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.crossover.cliente.response.ClientesIdResponse_v2Pip;
import utils.PatternRegex;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingCartResponse_v1_Customer {
    private BigInteger customerCode;
    private String customerType;
    private String name;
    private String cpf;
    private String dateOfBirth;
    private String gender;
    private String civilStatus;
    private String rg;
    private String orgaoEmissorRg;
    @Pattern(regexp = PatternRegex.DATE_YYYY_MM_DDTHH_MM_SS)
    private String lastUpdateTime;
    private String alternativeEmail1;
    private String alternativeEmail2;
    private Long associateCode;
    private Long associateRegistry;
    @Valid
    private ShoppingCartResponse_v1_Customer_DeliveryAddress deliveryAddress;
    @Valid
    private ShoppingCartResponse_v1_Customer_DeliveryContact deliveryContact;
    private String email;

    public static ShoppingCartResponse_v1_Customer normalizaCiente(ClientesIdResponse_v2Pip clientesIdResponse_v2Pip) {
        return ShoppingCartResponse_v1_Customer.builder()
                .customerCode(clientesIdResponse_v2Pip.getCodEntidadeComercial())
                .customerType(clientesIdResponse_v2Pip.getTipo())
                .name(clientesIdResponse_v2Pip.getNome())
                .cpf(clientesIdResponse_v2Pip.getCpf())
                .dateOfBirth(LocalDate.parse(clientesIdResponse_v2Pip.getDtNascimento(), PatternRegex.FORMATTER_DD_MM_YYYY).toString())
                .gender(clientesIdResponse_v2Pip.getSexo())
                .civilStatus(clientesIdResponse_v2Pip.getEstadoCivil().toString())
                .lastUpdateTime(clientesIdResponse_v2Pip.getDataUltimaAlteracao())
                .email(clientesIdResponse_v2Pip.getUsuario().getEmail())
                .build();
    }

}

