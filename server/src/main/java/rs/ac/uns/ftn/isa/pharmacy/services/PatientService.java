package rs.ac.uns.ftn.isa.pharmacy.services;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.isa.pharmacy.domain.users.user.Patient;
import rs.ac.uns.ftn.isa.pharmacy.repository.patients.PatientRepository;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }
    public List<Patient> getAppointedBy(long employeeId){
        return repository.getAppointedBy(employeeId);
    }
    public Patient get(long patientId){
        return repository.getOne(patientId);
    }
}