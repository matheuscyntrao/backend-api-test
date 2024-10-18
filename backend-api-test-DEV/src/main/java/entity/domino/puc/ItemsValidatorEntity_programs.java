package entity.domino.puc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsValidatorEntity_programs {
    private String program;
    private String programManager;
    private Instant inclusionDate;
    private Instant exclusionDate;
}
