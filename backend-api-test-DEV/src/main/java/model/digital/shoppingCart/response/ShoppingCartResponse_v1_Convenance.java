package model.digital.shoppingCart.response;

import lombok.Data;
import model.digital.shoppingCart.enums.ChannelEnum;

import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Convenance {
    private Long code;
    private String registration;
    private String cardNumber;
    private Long codigoFilialConvenio;
    private String pagamentoTaxaEntrega;
    private Boolean utilizaCartao;
    private Boolean utilizaSenha;
    private String description;
}
