package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary_BusinessHours {
    private String start;
    private String end;

    public Subsidiary_BusinessHours formatBusinessHours(String start, String end){
        return Subsidiary_BusinessHours.builder()
                .start(start)
                .end(end)
                .build();
    }
}
