package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subsidiary_Schedules {
    private Subsidiary_BusinessHours monday;
    private Subsidiary_BusinessHours tuesday;
    private Subsidiary_BusinessHours wednesday;
    private Subsidiary_BusinessHours thursday;
    private Subsidiary_BusinessHours friday;
    private Subsidiary_BusinessHours saturday;
    private Subsidiary_BusinessHours sunday;

    public Subsidiary_Schedules formatWeekDays(String start, String end) {
        Subsidiary_BusinessHours businessHours = new Subsidiary_BusinessHours().formatBusinessHours(start, end);
        return Subsidiary_Schedules.builder()
                .monday(businessHours)
                .tuesday(businessHours)
                .wednesday(businessHours)
                .thursday(businessHours)
                .friday(businessHours)
                .saturday(businessHours)
                .sunday(businessHours)
                .build();
    }
}
