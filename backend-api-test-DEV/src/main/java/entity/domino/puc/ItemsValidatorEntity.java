package entity.domino.puc;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;
import java.util.List;

@Data
@Entity("clients")
public class ItemsValidatorEntity {
    @Id
    private ObjectId id;
    private String document;
    private Long code;
    private List<ItemsValidatorEntity_programs> programs;
    private List<ItemsValidatorEntity_wallet> wallet;
    private Instant creationDate;
    private String _class;
    private Instant exclusionDate;
}
