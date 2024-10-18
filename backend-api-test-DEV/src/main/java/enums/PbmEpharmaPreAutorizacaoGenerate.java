package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item;
import model.timeB.pbm.request.PostPreAutorizacaoRequest_v4_Item_Receita;

import java.math.BigDecimal;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PbmEpharmaPreAutorizacaoGenerate {
    AUTORIZACAO_VALIDA {
        @Override
        public PostPreAutorizacaoRequest_v4 pojo() {
            return PostPreAutorizacaoRequest_v4.builder()
                    .canalVenda(2)
                    .codigoFilial(101L)
                    .tipoPrograma("C")
                    .usuario("RGARCIA")
                    .cnpjOrigem("92665611013406")
                    .codigoPrograma("88")
                    .itens(Arrays.asList(PostPreAutorizacaoRequest_v4_Item.builder().codigoItem(581950L)
                            .ean("7897705201770")
                            .precoBruto(new BigDecimal(49.64))
                            .precoLiquido(new BigDecimal(49.64))
                            .quantidadeSolicitada(1)
                            .receita(PostPreAutorizacaoRequest_v4_Item_Receita.builder().codigoProfissional(30828)
                                    .dataReceita("15/10/2020")
                                    .tipoProfissional("CRM")
                                    .ufProfissional("SP")
                                    .build())
                            .build()))
                    .cartaoBeneficiario("002870000060101019")
                    .build();
        }
    };

    public abstract PostPreAutorizacaoRequest_v4 pojo();
}
