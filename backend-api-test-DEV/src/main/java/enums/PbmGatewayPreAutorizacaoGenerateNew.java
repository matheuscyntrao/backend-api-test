package enums;


import enums.time_b.pbm.PbmEnum;
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
public enum PbmGatewayPreAutorizacaoGenerateNew {
    NOVO {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum) {
            Cache.valores.put(Util.rota.apply("CPFADESAO"), CPF.geraCPF());
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(2)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    .cpfBeneficiary(Cache.valores.get(Util.rota.apply("CPFADESAO")))
                    .cpfAttendance(Cache.valores.get(Util.rota.apply("CPFADESAO")))
                    .typeProgram("I")
                    .itemPreAuthorization(Arrays.asList(new PostPreAutorizacaoRequest_v1_ItemPreAuthorization()
                            .generate(pbmEnum)))
                    .user("AUTHB2C")
                    .build();
        }
    },
    EPHARMA_EXISTENTE {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum) {
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(2)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    //.cpfBeneficiary(Cache.valores.get("CPFADESAO"))
                    .cpfBeneficiary("25473930000")
                    .cpfAttendance("04190456004")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .itemPreAuthorization(Arrays.asList(PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder().codeItem(581950L)
                            .ean("7897705201770")
                            .quantityRequest(1)
                            .priceGross(new BigDecimal("361.00"))
                            .priceNet(new BigDecimal("362.00"))
                            .identifier("UUID_do_item_shopping_cart")
                            .build()))
                    .build();
        }
    },
    FUNCIONAL_EXISTENTE {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum) {
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(1)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    .cpfBeneficiary("00955037816")
                    .cpfAttendance("00955037816")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .itemPreAuthorization(Arrays.asList(
                            new PostPreAutorizacaoRequest_v1_ItemPreAuthorization()
                                    .generate(PbmEnum.SEVEN_DURMA_BEM)
                            )
                    )
                    .build();
        }
    },
    ZICARD {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum) {
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(1)
                    .channelOrigin("APP")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    .cpfBeneficiary("25473930000")
                    .cpfAttendance("04190456004")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .itemPreAuthorization(Arrays.asList(
                            new PostPreAutorizacaoRequest_v1_ItemPreAuthorization()
                                    .generate(PbmEnum.ZICARD_DERMACLUB)
                            )
                    )
                    .build();
        }
    },
    SEVEN_EXISTENTE {
        @Override
        public PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum) {
            return PostPreAutorizacaoRequest_v1.builder()
                    .channel(2)
                    .channelOrigin("SITE")
                    .codeProgram("107")
                    .codeSubsidiary(368)
                    //.cpfBeneficiary(Cache.valores.get("CPFADESAO"))
                    .cpfBeneficiary("98121152267")
                    .cpfAttendance("98121152267")
                    .typeProgram("I")
                    .user("AUTHB2C")
                    .itemPreAuthorization(Arrays.asList(PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder().codeItem(880550l)
                            .ean("7896658030451")
                            .quantityRequest(1)
                            .identifier("UUID_do_item_shopping_cart")
                            .priceGross(new BigDecimal("500.00"))
                            .priceNet(new BigDecimal("300.00"))
                            .build()))
                    .build();
        }
    };

    public abstract PostPreAutorizacaoRequest_v1 pojo(PbmEnum pbmEnum);
}
