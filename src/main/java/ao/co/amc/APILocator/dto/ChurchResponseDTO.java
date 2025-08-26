package ao.co.amc.APILocator.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChurchResponseDTO {
    private UUID id;
    private Integer number;
    private String name;
    private String acronym;
    private UUID pastorId;
    private String neighborhood;
    private String municipality;
    private String province;
    private int ministerOfReligion;
    private int numberOfTemples;
    private Integer numberOfBelievers;
    private Double latitude;
    private Double longitude;

}
