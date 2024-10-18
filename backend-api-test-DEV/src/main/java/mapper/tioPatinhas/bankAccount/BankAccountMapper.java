package mapper.tioPatinhas.bankAccount;

import model.crossover.cliente.response.*;
import model.tioPatinhas.bankAccount.response.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
public class BankAccountMapper {

    public static GetAndPutAccountByCpfV1Response mapCustomerDataToAccountModel(GetClientePipClientesCpfResponse_v2 clientesIdResponse_v2Pip) {
        return GetAndPutAccountByCpfV1Response.builder()
                .client(
                        getCliente(clientesIdResponse_v2Pip)
                )
                .billingAddress(
                        getBillingAddress(clientesIdResponse_v2Pip.getEnderecos())
                )
                .build();
    }

    private static GetBillingAddressV1Response getBillingAddress(List<GetClientePipClientesCpfResponse_v2_Endereco> enderecos) {
        GetClientePipClientesCpfResponse_v2_Endereco endereco = getEnderecoCobrancaCliente(enderecos);
        if (endereco == null) return null;
        return GetBillingAddressV1Response.builder()
                .address(endereco.getLogradouro())
                .number(String.valueOf(endereco.getNumero()))
                .complement(endereco.getComplemento())
                .district(endereco.getBairro())
                .city(endereco.getCidade())
                .state(endereco.getUf())
                .zipCode(String.valueOf(endereco.getCep()))
                .country("BRA")
                .build();
    }

    private static GetClientePipClientesCpfResponse_v2_Endereco getEnderecoCobrancaCliente(List<GetClientePipClientesCpfResponse_v2_Endereco> enderecos) {
        Optional<GetClientePipClientesCpfResponse_v2_Endereco> opEndereco = enderecos.stream()
                .filter(e -> !CollectionUtils.isEmpty(e.getTiposEndereco())
                        && e.getTiposEndereco().stream().anyMatch(it -> it.getCodigo() == 17))
                .findFirst();
        if (opEndereco.isEmpty()) {
            return null;
        }
        return opEndereco.get();
    }

    private static GetMailAddressV1Response getMailAddress(List<GetClientePipClientesCpfResponse_v2_Endereco> enderecos) {
        GetClientePipClientesCpfResponse_v2_Endereco endereco = getEnderecoCobrancaCliente(enderecos);
        if (endereco == null) return null;
        return GetMailAddressV1Response.builder()
                .address(endereco.getLogradouro())
                .number(String.valueOf(endereco.getNumero()))
                .complement(endereco.getComplemento())
                .district(endereco.getBairro())
                .city(endereco.getCidade())
                .state(endereco.getUf())
                .zipCode(String.valueOf(endereco.getCep()))
                .country("BRA")
                .build();
    }

    private static GetClientV1Response getCliente(GetClientePipClientesCpfResponse_v2 client) {

        return GetClientV1Response.builder()
                .name(client.getNome())
                .email(getEmail(client.getContatos()))
                .birthDate(client.getDtNascimento())
                .taxIdentifier(GetTaxIdentifierV1Response.builder()
                        .country("BRA")
                        .taxId(client.getCpf())
                        .build())
                .mailAddress(
                        getMailAddress(client.getEnderecos())
                )
                .build();
    }

    private static String getEmail(List<GetClientePipClientesCpfResponse_v2_Contato> contatos) {
        Optional<GetClientePipClientesCpfResponse_v2_Contato> contato = contatos.stream()
                .filter(c -> c.getEmail() != null
                        && c.getCodTipoComunicacao().intValue() == 4)
                .findFirst();
        if (contato.isEmpty()) {
            return null;
        }

        return contato.get().getEmail().toUpperCase(Locale.ROOT);
    }
}