package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PbmZicardPreAutorizacaoGenerate {
    AUTORIZACAO_VALIDA {
        @Override
        public PostPreAutorizacaoRequest_v4 pojo() {
            return PostPreAutorizacaoRequest_v4.builder()
                    .canalVenda(3)
                    .origemCanal(1)
                    .codigoFilial(31L)
                    .tipoPrograma("I")
                    .usuario("AUTHB2C")
                    .cnpjOrigem("92665611010130")
                    .cpfBeneficiario("04559791031")
                    .cartaoBeneficiario("04559791031")
                    .codigoPrograma("113")
                    .itens(Arrays.asList(PostPreAutorizacaoRequest_v4_Item.builder()
                            .codigoItem(848190L)
                            .ean("3433422406728")
                            .quantidadeSolicitada(1)
                            .precoBruto(new BigDecimal("89.99"))
                            .precoLiquido(new BigDecimal("89.99"))
                            .build()))
                    .build();
        }
    };

    public abstract PostPreAutorizacaoRequest_v4 pojo();
}
