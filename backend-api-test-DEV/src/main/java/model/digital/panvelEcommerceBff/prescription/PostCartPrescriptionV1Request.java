package model.digital.panvelEcommerceBff.prescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.prescription.orm.Item;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCartPrescriptionV1Request {
    public List<Item> items;
}
