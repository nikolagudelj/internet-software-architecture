package rs.ac.uns.ftn.isa.pharmacy.services.schedule;

import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.isa.pharmacy.domain.schedule.Appointment;
import rs.ac.uns.ftn.isa.pharmacy.repository.schedule.AppointmentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AppointmentService {
    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Transactional
    public List<Appointment> findFreeExaminationsByPharmacy(long pharmacyId) {
        return repository.findFreeExaminations()
                .stream()
                .filter(a -> a.getShift().getPharmacy().getId() == pharmacyId)
                .collect(Collectors.toList());
    }

    public Appointment createFreeExamination(Appointment appointment) {
        return repository.save(appointment);
    }
}
