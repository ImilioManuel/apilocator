package ao.co.amc.APILocator.dto;

import java.time.LocalDate;

public class PastorDTO {
    private String name;
    private String email;
    private String contact1;
    private String contact2;
    private LocalDate dateOfBirth;

    public PastorDTO() {}

    public PastorDTO(String name, String email, String contact1, String contact2, LocalDate dateOfBirth, byte[] photo) {
        this.name = name;
        this.email = email;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.dateOfBirth = dateOfBirth;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
