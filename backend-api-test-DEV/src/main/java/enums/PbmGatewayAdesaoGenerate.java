package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import model.timeB.pbmGatewayService.request.*;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1;

@Getter
@AllArgsConstructor
public enum PbmGatewayAdesaoGenerate {
    EPHARMA_NOVO {
        @Override
        public PostAdesaoRequest_v1 pojo(PostPreAutorizacaoResponse_v1 responsePre) {
            return PostAdesaoRequest_v1.builder()
                    .customerData(PostAdesaoRequest_v1_CustomerData.builder()
                            .serviceOrigin(1L)
                            .build())
                    .fields(new PostAdesaoRequest_v1_Fields().responsePreToPostAdesao(responsePre))
                    .transactionControl(responsePre.getDeviationFlux().getTransactionControl())
                    .build();
        }
    },
    FUNCIONAL_NOVO {
        @Override
        public PostAdesaoRequest_v1 pojo(PostPreAutorizacaoResponse_v1 responsePre) {
            return PostAdesaoRequest_v1.builder()
                    .customerData(PostAdesaoRequest_v1_CustomerData.builder()
                            .serviceOrigin(1L)
                            .build())
                    .fields(new PostAdesaoRequest_v1_Fields().responsePreToPostAdesao(responsePre))
                    .transactionControl(responsePre.getDeviationFlux().getTransactionControl())
                    .build();
        }
    },
    SEVEN_NOVO {
        @Override
        public PostAdesaoRequest_v1 pojo(PostPreAutorizacaoResponse_v1 responsePre) {
            return PostAdesaoRequest_v1.builder()
                    .customerData(PostAdesaoRequest_v1_CustomerData.builder()
                            .serviceOrigin(1L)
                            .build())
                    .fields(new PostAdesaoRequest_v1_Fields().responsePreToPostAdesao(responsePre))
                    .transactionControl(responsePre.getDeviationFlux().getTransactionControl())
                    .build();
        }
    };

    public abstract PostAdesaoRequest_v1 pojo(PostPreAutorizacaoResponse_v1 reponsePre);
}
