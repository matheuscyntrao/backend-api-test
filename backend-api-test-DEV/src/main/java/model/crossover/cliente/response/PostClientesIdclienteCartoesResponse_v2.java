package model.crossover.cliente.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostClientesIdclienteCartoesResponse_v2 {
    private String status;
    private BigInteger idCartao;
}
