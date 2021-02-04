package rs.ac.uns.ftn.isa.pharmacy.domain.locale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.ftn.isa.pharmacy.domain.locale.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
