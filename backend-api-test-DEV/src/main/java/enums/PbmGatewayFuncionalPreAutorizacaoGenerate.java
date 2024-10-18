package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;
import utils.CPF;
import utils.Util;
import utils.service.Cache;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PbmGatewayFuncionalPreAutorizacaoGenerate {
    AUTORIZACAO_VALIDA_ADESAO {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo() {
            Cache.valores.put(Util.rota.apply("CPFADESAO"), CPF.geraCPF());
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(1)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    .cpfBeneficiary("04190456004")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .cpfBeneficiary(Cache.valores.get(Util.rota.apply("CPFADESAO")))
                    .itemPreAuthorization(Arrays.asList(PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder().codeItem(501640L)
                            .ean("7896015518875")
                            .quantityRequest(1)
                            .priceGross(new BigDecimal("70.00"))
                            .priceNet(new BigDecimal("15"))
                            .build()))
                    .build();
        }
    },
    AUTORIZACAO_VALIDA {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo() {
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(1)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    .cpfBeneficiary("04190456004")
                    .cpfAttendance("04190456004")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .itemPreAuthorization(Arrays.asList(PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder().codeItem(501640L)
                            .ean("7896015518875")
                            .quantityRequest(1)
                            .priceGross(new BigDecimal("70.00"))
                            .priceNet(new BigDecimal("15"))
                            .build()))
                    .build();
        }
    };
    public abstract PostPreAutorizacaoRequest_v1 pojo();
}
