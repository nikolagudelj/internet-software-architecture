package rs.ac.uns.ftn.isa.pharmacy.domain.locale;

import rs.ac.uns.ftn.isa.pharmacy.domain.supply.exceptions.InvalidEntityException;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private City city;
    private String streetName;
    private double latitude;
    private double longitude;

    public void validate() throws InvalidEntityException {
        if (streetName == null) throw new InvalidEntityException("Address street name");
        city.validate();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return streetName + ", " + city.toString();
    }
}
