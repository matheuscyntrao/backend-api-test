package model.domino.convenio.request;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ConvenioDetalharRequest_v2_Matricula {
    private String matricula;
    private BigInteger convenio;
    private BigInteger codigoDependente;
}
