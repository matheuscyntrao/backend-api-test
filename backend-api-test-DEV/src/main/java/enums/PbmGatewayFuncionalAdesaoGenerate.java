package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbmGatewayService.request.*;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;

@Getter
@AllArgsConstructor
public enum PbmGatewayFuncionalAdesaoGenerate {
    FUNCIONAL {
        @Override
        public PostAdesaoFuncionalRequest_v1 pojo(PostPreAutorizacaoResponse_v1 responsePre) {
            return PostAdesaoFuncionalRequest_v1.builder()
                    .fields(new PostAdesaoFuncionalRequest_v1_Fields().responsePreToPostAdesao(responsePre))
                    .fieldsControl(responsePre.getDeviationFlux().getTransactionControl())
                    .build();
        }
    };

    public abstract PostAdesaoFuncionalRequest_v1 pojo(PostPreAutorizacaoResponse_v1 reponsePre);
}
