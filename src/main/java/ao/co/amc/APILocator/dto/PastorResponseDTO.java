package ao.co.amc.APILocator.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PastorResponseDTO {
    private String name;
    private String email;
    private String contact1;
    private String contact2;
    private LocalDate dateOfBirth;
}
