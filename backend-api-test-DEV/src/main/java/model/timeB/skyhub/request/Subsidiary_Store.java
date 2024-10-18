package model.timeB.skyhub.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.timeB.skyhub.response.Subsidiary;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary_Store {
    private Subsidiary store;
}
