package model.avengers.mostruario.request;

import enums.time_b.pbm.PbmEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.timeB.pbmGatewayService.request.PostPreAutorizacaoRequest_v1_ItemPreAuthorization;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItensDetalheRequest_v3 {
    private Integer filial;
    private List<ItensDetalheRequest_v3_Convenio> convenios;
    private Integer perfil;
    private Integer cep;
    private List<ItensDetalheRequest_v3_Item> itens;
    private ItensDetalheRequest_v3_ConsultaRegrasFiscais consultaRegrasFiscais;
    private BigInteger codigoCupomOfertas;

    public ItensDetalheRequest_v3 createDetalhe(Integer filial, Integer produto, Integer perfil) {
        if(perfil!= null && perfil == 1) {
            return ItensDetalheRequest_v3.builder()
                    .filial(filial)
                    .perfil(1)
                    .itens(new ItensDetalheRequest_v3_Item().createItens(produto))
                    .consultaRegrasFiscais(new ItensDetalheRequest_v3_ConsultaRegrasFiscais().createConsultaRegrasFiscaisSp(filial))
                    .build();
        } else {
            return ItensDetalheRequest_v3.builder()
                    .filial(filial)
                    .perfil(2)
                    .convenios(new ItensDetalheRequest_v3_Convenio().createConvenios())
                    .itens(new ItensDetalheRequest_v3_Item().createItens(produto))
                    .consultaRegrasFiscais(new ItensDetalheRequest_v3_ConsultaRegrasFiscais().createConsultaRegrasFiscaisSp(filial))
                    .build();
        }
    }
}