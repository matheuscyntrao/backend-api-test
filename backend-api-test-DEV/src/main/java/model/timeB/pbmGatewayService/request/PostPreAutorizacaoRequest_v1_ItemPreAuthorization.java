package model.timeB.pbmGatewayService.request;

import enums.time_b.pbm.PbmEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.avengers.mostruario.request.ItensDetalheRequest_v3;
import model.avengers.mostruario.response.ItensDetalheResponseV3;
import queries.timeB.pbm.PbmItemQuerie;
import service.avengers.mostruario.Mostruariov3;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostPreAutorizacaoRequest_v1_ItemPreAuthorization {
    private Long codeItem;
    private String ean;
    private PostPreAutorizacaoRequest_v1_ItemPreAuthorization_Prescription prescription;
    private BigDecimal priceGross;
    private BigDecimal priceNet;
    private Number quantityRequest;
    private Boolean responseOperator;
    private String identifier;

    public PostPreAutorizacaoRequest_v1_ItemPreAuthorization generate(PbmEnum pbmEnum) {
        String item = PbmItemQuerie.getPbmItem(pbmEnum);
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_DETALHE), new ItensDetalheRequest_v3().createDetalhe(101, Integer.parseInt(item), null));
        Mostruariov3.postDetalhe.run();
        ItensDetalheResponseV3 responseV3 = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class);
        return PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder()
                .identifier("ZmudaIdentifie")
                .codeItem(Long.parseLong(item))
                .ean(responseV3.getItens().get(0).getEan().toString())
                .priceGross(responseV3.getItens().get(0).getPrecoDe())
                .priceNet(responseV3.getItens().get(0).getPrecoPor())
                .build();
    }

    public PostPreAutorizacaoRequest_v1_ItemPreAuthorization generateByItem(String item) {
        BuilderRequest.body.accept(Util.rota.apply(Mostruariov3.POST_DETALHE), new ItensDetalheRequest_v3().createDetalhe(101, Integer.parseInt(item), 2));
        Mostruariov3.postDetalhe.run();
        ItensDetalheResponseV3 responseV3 = Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class);
        return PostPreAutorizacaoRequest_v1_ItemPreAuthorization.builder()
                .identifier("ZmudaIdentifie")
                .codeItem(Long.parseLong(item))
                .ean(responseV3.getItens().get(0).getEan().toString())
                .priceGross(responseV3.getItens().get(0).getPrecoDe())
                .priceNet(responseV3.getItens().get(0).getPrecoPor())
                .build();
    }
}
