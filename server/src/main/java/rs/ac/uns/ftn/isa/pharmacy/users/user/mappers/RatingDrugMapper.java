package rs.ac.uns.ftn.isa.pharmacy.users.user.mappers;

import rs.ac.uns.ftn.isa.pharmacy.pharma.domain.Drug;
import rs.ac.uns.ftn.isa.pharmacy.users.user.dtos.RatingDrugDto;

public class RatingDrugMapper {
    public static RatingDrugDto objectToDto(Drug drug) {
        return new RatingDrugDto(
                drug.getId(),
                drug.getName(),
                drug.getRating(),
                drug.getManufacturer()
        );
    }
}
