package rs.ac.uns.ftn.isa.pharmacy.domain.users.employee;

import rs.ac.uns.ftn.isa.pharmacy.domain.users.user.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Person person;
    private EmployeeType employeeType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "employee")
    private List<Shift> shifts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }

    public boolean hasShiftAtPharmacy(Term term, double pharmacyId) {
        for(var shift:shifts)
            if (shift.getPharmacy().getId() != pharmacyId)
                continue;
            else
                if(term.isInRange(shift.getStart(),shift.getEnd()))
                    return true;

        return false;
    }

    public boolean isOccupied(Term term) {
        for(var shift : shifts){
            if(shift.hasScheduledExam(term))
                return true;
        }
        return false;
    }

    public Shift getAdequateShift(Term term) {
        for(var shift : shifts)
            if(term.isInRange(shift.getStart(),shift.getEnd()))
                return shift;
        return null;
    }
}
