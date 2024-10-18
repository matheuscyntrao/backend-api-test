package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PbmFuncionalPreAutorizacaoGenerate {
    AUTORIZACAO_VALIDA {
        @Override
        public PostPreAutorizacaoRequest_v4 pojo() {
            return PostPreAutorizacaoRequest_v4.builder()
                    .canalVenda(1)
                    .codigoFilial(101L)
                    .tipoPrograma("I")
                    .usuario("TESTE PRE AUTORIZACAO")
                    .cnpjOrigem("92665611013406")
                    .cpfBeneficiario("02807802060")
                    .cartaoBeneficiario("02807802060")
                    .codigoPrograma("107")
                    .itens(Arrays.asList(PostPreAutorizacaoRequest_v4_Item.builder().codigoItem(501640L)
                            .ean("7896015518875")
                            .quantidadeSolicitada(1)
                            .precoBruto(new BigDecimal("56.54"))
                            .precoLiquido(new BigDecimal("56.54"))
                            .build()))
                    .build();
        }
    };

    public abstract PostPreAutorizacaoRequest_v4 pojo();
}
