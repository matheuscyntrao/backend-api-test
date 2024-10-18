package model.domino.convenio.request;

import lombok.Data;

import java.util.List;

@Data
public class ConvenioDetalharRequest_v2 {
    private Long filial;
    private List<String> cartoes;
    private List<String> trilhas;
    private List<String> perfilVenda;
    private Boolean descontoAcumulado;
    private Boolean consultaBeneficios;
    private ConvenioDetalharRequest_v2_Matricula matriculas[];
}
