
package ao.co.amc.APILocator.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.UUID;


@Entity
@Table(name = "church")
public class Church {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @NotBlank
    @Size(max = 100)
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 20)
    @Column(name = "acronym", length = 20)
    private String acronym;

    @OneToOne
    @JoinColumn(name = "pastor_id")
    private Pastor pastor;

    @NotBlank
    @Column(name = "neighborhood", nullable = false, length = 100)
    private String neighborhood;

    @NotBlank
    @Column(name = "municipality", nullable = false, length = 100)
    private String municipality;

    @NotBlank
    @Column(name = "province", nullable = false, length = 100)
    private String province;

    @Column(name = "minister_of_religion")
    private int ministerOfReligion;

    @Column(name = "number_of_temples")
    private int numberOfTemples;

    @Column(name = "number_of_believers")
    private Integer numberOfBelievers;


    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Lob
    @Column(name = "logotype", columnDefinition = "LONGBLOB")
    private byte[] logotype;

    public Church() {
    }

    public Church(UUID id, Integer number, String name, String acronym, Pastor pastor, String neighborhood, String municipality, String province, int ministerOfReligion, int numberOfTemples, Integer numberOfBelievers, Double latitude, Double longitude, byte[] logotype) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.acronym = acronym;
        this.pastor = pastor;
        this.neighborhood = neighborhood;
        this.municipality = municipality;
        this.province = province;
        this.ministerOfReligion = ministerOfReligion;
        this.numberOfTemples = numberOfTemples;
        this.numberOfBelievers = numberOfBelievers;
        this.latitude = latitude;
        this.longitude = longitude;
        this.logotype = logotype;
    }
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Pastor getPastor() {
        return pastor;
    }

    public void setPastor(Pastor pastor) {
        this.pastor = pastor;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getMinisterOfReligion() {
        return ministerOfReligion;
    }

    public void setMinisterOfReligion(int ministerOfReligion) {
        this.ministerOfReligion = ministerOfReligion;
    }

    public int getNumberOfTemples() {
        return numberOfTemples;
    }

    public void setNumberOfTemples(int numberOfTemples) {
        this.numberOfTemples = numberOfTemples;
    }

    public Integer getNumberOfBelievers() {
        return numberOfBelievers;
    }

    public void setNumberOfBelievers(Integer numberOfBelievers) {
        this.numberOfBelievers = numberOfBelievers;
    }
    public byte[] getLogotype() {
        return logotype;
    }
    public void setLogotype(byte[] logotype) {
        this.logotype = logotype;
    }
}
