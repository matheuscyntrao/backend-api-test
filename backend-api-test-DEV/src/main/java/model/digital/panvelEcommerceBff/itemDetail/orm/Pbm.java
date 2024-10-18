package model.digital.panvelEcommerceBff.itemDetail.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pbm {
    private Long codeAdmConvenant;
    private Long codeCovenant;
    private BigDecimal dealPrice;
    private String pathImage;
    private String programName;
    private String typeProgram;
}
