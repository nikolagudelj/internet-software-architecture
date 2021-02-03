package rs.ac.uns.ftn.isa.pharmacy.domain.pharma;

import rs.ac.uns.ftn.isa.pharmacy.domain.users.user.Patient;
import rs.ac.uns.ftn.isa.pharmacy.exceptions.DateException;
import rs.ac.uns.ftn.isa.pharmacy.exceptions.QuantityException;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "drug_reservations")
public class DrugReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private StoredDrug storedDrug;
    private LocalDate pickUpBefore;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public StoredDrug getStoredDrug() {
        return storedDrug;
    }

    public void setStoredDrug(StoredDrug storedDrug) {
        this.storedDrug = storedDrug;
    }

    public LocalDate getPickUpBefore() {
        return pickUpBefore;
    }

    public void setPickUpBefore(LocalDate pickUpBefore) {
        if (pickUpBefore.isBefore(LocalDate.now())) {
            throw new DateException();
        }
        this.pickUpBefore = pickUpBefore;
    }

    public int getQuantity() {
        if (quantity < 1) {
            throw new QuantityException();
        }
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}