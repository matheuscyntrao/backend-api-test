package model.digital.panvelEcommerceBff.prescription.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    public List<Buyer> buyer;
    public Long itemCode;
    public List<Patient> patient;
    public List<Prescriber> prescriber;
    public List<Prescription> prescription;
}
