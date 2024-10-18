package model.timeB.pbmGatewayService.request;

import lombok.*;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_formAccess;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields;
import utils.CPF;
import utils.PatternRegex;
import utils.Util;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAdesaoRequest_v1_Fields {
    private String entity;
    private String description;
    private List<PostAdesaoRequest_v1_Fields_Field> field;
    public List<PostAdesaoRequest_v1_Fields> responsePreToPostAdesao(PostPreAutorizacaoResponse_v1 responsePre) {
        return responsePre.getDeviationFlux().getFormAccess().stream()
                .map(form -> PostAdesaoRequest_v1_Fields.builder()
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
                .value(Mocks.getValueFromCode(questao.getCode()))
                .build();
    }
    @AllArgsConstructor
    @Getter
    private enum Mocks {

        //EPHARMA
        DATA_NASCIMENTO_EPHARMA("1_9", () -> "10/10/2000"),
        SEXO_EPHARMA("1_10", () -> "M"),
        EMAIL_EPHARMA("1_50", () -> Cache.faker.bothify(PatternRegex.FAKER_EMAIL)),
        TELEFONE("1_19", () -> "51989998989"),
        CEP_EPHARMA("1_18", () -> "92500000"),
        CIDADE_EPHARMA("1_16", () -> "Porto Alegre"),
        ESTADO_EPHARMA("1_17", () -> "RS"),
        NOME_EPHARMA("1_3", () -> "nome de teste"),
        //NUMERO("Numero", () -> "21"),
        CELULAR("1_21", () -> "51989998741"),
        UF_CRM("30_228_306", () -> "721"),
        CRM("30_228_305", () -> "5657"),
        NOME_MEDICO("30_228_307", () -> "Nome Do Medico"),
        ACESSO_AREA_LOGADA("30_228_310", () -> "2"),
        TERMOS_CONDICOES("30_228_311", () -> "true"),
        INFORMACOES_AO_PACIENTE("30_228_312", () -> "true"),
        CONCORDO_SER_CONTATADO("30_228_313", () -> "true"),
        CPF_RESPONSAVEL("30_228_308", () -> Cache.valores.get(Util.rota.apply("CPFADESAO"))),
        NOME_RESPONSAVEL("30_228_309", () -> "nome responsavel"),

        // FUNCIONAL
        DOCUMENTO("CPF",() -> Cache.valores.get(Util.rota.apply("CPFADESAO"))),
        DATA_NASCIMENTO_FUNCIONAL("Nascimento", () -> "10/10/2000"),
        SEXO_FUNCIONAL("Sexo", () -> "M"),
        CEP("CEP", () -> "92706040"),
        RUA("Endereco", () -> "endereco teste"),
        CIDADE("Cidade", () -> "Porto Alegre"),
        NUMERO_FUNCIONAL_("Número", () -> "21"),
        COMPLEMENTO("Complemento", () -> "complemento teste"),
        UF("UF", () -> "RS"),
        NASCIMENTO_FUNCIONAL("Nascimento", () -> "02/10/1983"),
        NOME_FUNCIONAL("Nome", () -> "nome de teste"),
        TELEFONE_RESIDENCIAL("TelefoneComercial", () -> "5134804410"),
        CELULAR_FUNCIONAL("TelefoneCelular", () -> "51989998741"),
        OUTRO_TELEFONE("Outro Telefone", () -> "51989998741"),
        EMAIL_FUNCIONAL("Email", () -> Cache.faker.bothify(PatternRegex.FAKER_EMAIL)),
        CONTATO_EMAIL("PermiteContatoEmail", () -> "true"),
        CONTATO_SMS("PermiteContatoSms", () -> "true"),
        CONTATO_TELEFONE("PermiteContatoTelefone", () -> "true"),
        CONTATO_CORREIO("aceitaContatoCorreios", () -> "true"),
        TIPO_CONSELHO("TipoConselho", () -> "0"),
        PACIENTE_TITULAR("Titular", () -> "true"),
        NUMERO_REGISTRO("NumeroRegistroConselho", () -> "5657"),
        PATOLOGIA("CodigoPatologia", () -> "7"),
        UF_CRM_FUNCIONAL("UF", () -> "RS"),

        // SEVEN
        DDD_CELULAR_SEVEN("dddCelular", () -> "51"),
        CELULAR_SEVEN("celular", () -> Cache.faker.bothify("99#######")),
        NOME_COMPLETO_SEVEN("nomeCompleto", () -> "teste seven"),
        DATA_NASCIMENTO_SEVEN("dataNascimento", () -> "2000-10-10"),
        SEXO_SEVEN("sexo", () -> "Masculino"),
        DDD_FIXO_SEVEN("dddFixo", () -> "51"),
        FIXO_SEVEN("telefoneFixo", () -> "34804410"),
        CEP_SEVEN("cep", () -> "92500000"),
        UF_SEVEN("uf", () -> "RS"),
        CIDADE_SEVEN("cidade", () -> "Guaíba"),
        BAIRRO_SEVEN("bairro", () -> "centro"),
        TIPO_LOGRADOURO_SEVEN("tipoLogradouro", () -> "Rua"),
        LOGRADOURO_SEVEN("logradouro", () -> "centro de testes"),
        NUMERO_SEVEN("numero", () -> "31"),
        COMPLEMENTO_SEVEN("complemento", () -> "esquina"),
        EMAIL_SEVEN("email", () -> Cache.faker.bothify(PatternRegex.FAKER_EMAIL)),
        ACEITA_CONTATO_TELEONE_SEVEN("aceitaContatoTelefone", () -> "true"),
        ACEITA_CONTATO_CORREIOS_SEVEN("CaceitaContatoCorreios", () -> "true"),
        ACEITA_CONTATO_SMS_SEVEN("aceitaContatoSms", () -> "true"),
        ACEITA_CONTATO_EMAIL_SEVEN("aceitaContatoEmail", () -> "true"),
        ACEITA_TERMOS_SEVEN("aceiteDoTermoDeAdesao", () -> "true"),
        TIPO_CONSELHO_SEVEN("tipoConselho", () -> "CRM"),
        NUMERO_REGISTRO_CONSELHO("numeroRegistroConselho", () -> "5657"),
        NOME_DO_MEDICO("nomeDoMedico", () -> "Nome do Medico");



        private final String responseCode;
        private final GenerateValueFunction requestValue;

        private static String getValueFromCode(String name) {
            return Arrays.stream(Mocks.values())
                    .filter(mock -> mock.getResponseCode().equals(name))
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
