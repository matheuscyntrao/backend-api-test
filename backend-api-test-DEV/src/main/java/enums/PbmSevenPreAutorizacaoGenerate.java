package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;
import utils.CPF;
import utils.service.Cache;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PbmSevenPreAutorizacaoGenerate {
    AUTORIZACAO_VALIDA {
        @Override

        public PostPreAutorizacaoRequest_v4 pojo() {
            return PostPreAutorizacaoRequest_v4.builder()
                    .canalVenda(1)
                    .tipoPrograma("I")
                    .usuario("RGARCIA")
                    .codigoFilial(101L)
                    .cnpjOrigem("92665611013406")
                    .cpfBeneficiario("48325260815")
                    .cpfAtendimento("48325260815")
                    .codigoPrograma("106")
                    .sequenciaPrograma(106L)
                    .itens(Arrays.asList(PostPreAutorizacaoRequest_v4_Item.builder().codigoItem(880550L)
                            .ean("7896658030451")
                            .quantidadeSolicitada(1)
                            .precoBruto(new BigDecimal("61.99"))
                            .precoLiquido(new BigDecimal("61.99"))
                            .build()))
                    .build();
        }
    };
    public abstract PostPreAutorizacaoRequest_v4 pojo();
}
