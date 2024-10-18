package model.plataforma.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostPaymentHashRequest_v1_Order_AntiFraudClient {
    private String cpf;
    private String mail;
    private String name;
}
