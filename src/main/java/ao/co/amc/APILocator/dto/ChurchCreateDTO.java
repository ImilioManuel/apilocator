package ao.co.amc.APILocator.dto;

import java.util.UUID;

public class ChurchCreateDTO {
    
    private Integer number;
    private String name;
    private String acronym;
    private UUID pastor;
    private String neighborhood;
    private String municipality;
    private String province;
    private int ministerOfReligion;
    private int numberOfTemples;
    private Integer numberOfBelievers;
    private Double latitude;
    private Double longitude;

    public ChurchCreateDTO() {}

    public ChurchCreateDTO(Integer number, String name, String acronym, UUID pastorId, String neighborhood, String municipality, String province, int ministerOfReligion, int numberOfTemples, Integer numberOfBelievers, Double latitude, Double longitude) {
        this.number = number;
        this.name = name;
        this.acronym = acronym;
        this.pastor = pastorId;
        this.neighborhood = neighborhood;
        this.municipality = municipality;
        this.province = province;
        this.ministerOfReligion = ministerOfReligion;
        this.numberOfTemples = numberOfTemples;
        this.numberOfBelievers = numberOfBelievers;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public UUID getPastorId() {
        return pastor;
    }

    public void setPastorId(UUID pastorId) {
        this.pastor = pastorId;
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
}
