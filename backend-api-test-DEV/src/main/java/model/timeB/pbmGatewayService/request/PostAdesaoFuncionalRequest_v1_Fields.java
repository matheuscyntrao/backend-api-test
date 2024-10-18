package model.timeB.pbmGatewayService.request;

import lombok.*;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_formAccess;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAdesaoFuncionalRequest_v1_Fields {
    private String entity;
    private String description;
    private List<PostAdesaoRequest_v1_Fields_Field> field;
    public List<PostAdesaoFuncionalRequest_v1_Fields> responsePreToPostAdesao(PostPreAutorizacaoResponse_v1 responsePre) {
        return responsePre.getDeviationFlux().getFormAccess().stream()
                .map(form -> PostAdesaoFuncionalRequest_v1_Fields.builder()
                        .entity(form.getEntity())
                        .description(form.getDescription())
                        .field(mapToRequestField(form))
                        .build())
                .collect(Collectors.toList());
    }

    private List<PostAdesaoRequest_v1_Fields_Field> mapToRequestField(PostPreAutorizacaoResponse_v1_deviationFlux_formAccess responsePre) {
        return responsePre.getFields().stream()
                .map(this::buildField)
                .collect(Collectors.toList());
    }

    private PostAdesaoRequest_v1_Fields_Field buildField(PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields questao) {
        return PostAdesaoRequest_v1_Fields_Field.builder()
                .code(questao.getCode())
                .value(Mocks.getValueFromName(questao.getName()))
                .build();
    }
    @AllArgsConstructor
    @Getter
    private enum Mocks {
        NOME("Nome Completo", () -> "nome de teste"),
        DATA_NASCIMENTO("Data de Nascimento", () -> "10/10/2000"),
        SEXO("Sexo", () -> "M"),
        CEP("CEP", () -> "92706040"),
        ENDERECO("Endereço", () -> "Rua de teste"),
        NUMERO("Número", () -> "21"),
        COMPLEMENTO("Complemento", () -> "casa"),
        BAIRRO("Bairro", () -> "bairro teste"),
        CIDADE("Cidade", () -> "GUAIBA"),
        ESTADO("UF", () -> "RS"),
        TELEFONE_RESIDENCIAL("Telefone Residencial", () -> "5134804410"),
        TELEFONE_CELULAR("Telefone Celular", () -> "51989998852"),
        OUTRO_TELEFONE("Outro Telefone", () -> "51989998852"),
        EMAIL("Email", () -> "teste@gmail.com"),
        CONTATO_POSTERIOR("Contato posterior E-mail?", () -> "true"),
        CONTATO_POSTERIOR_SMS("Contato posterior por SMS?", () -> "true"),
        CONTATO_POSTERIOR_FONE("Contato posterior por Telefone?", () -> "true"),
        CONTATO_POSTERIOR_CORREIO("Contato posterior por Correio?", () -> "true"),
        TIPO_CONSELHO("Tipo de conselho",()->"CRM"),
        UF_CRM("UF", () -> "RS"),
        CRM("Número de Registro", () -> "5657"),
        PATOLOGIA("Patologia",()->"HPB"),
        PACIENTE_TITULAR("Paciente é titular?",()->"true");


        private final String responseName;
        private final GenerateValueFunction requestValue;

        private static String getValueFromName(String name) {
            return Arrays.stream(Mocks.values())
                    .filter(mock -> mock.responseName.equals(name))
                    .map(Mocks::getRequestValue)
                    .findFirst().orElse(() -> null)
                    .generate();
        }
    }

    @FunctionalInterface
    private interface GenerateValueFunction {
        String generate();
    }
}
