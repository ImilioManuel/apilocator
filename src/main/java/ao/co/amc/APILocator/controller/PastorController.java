package ao.co.amc.APILocator.controller;

import ao.co.amc.APILocator.dto.PastorCreateDTO;
import ao.co.amc.APILocator.service.PastorService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pastors")
public class PastorController {

    @Autowired
    private PastorService pastorService;

    @GetMapping
    public List<PastorCreateDTO> getAllPastors() {
        return pastorService.findAllDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PastorCreateDTO> getPastorById(@PathVariable UUID id) {
        Optional<PastorCreateDTO> pastorDTO = pastorService.findById(id);
        return pastorDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public PastorCreateDTO createPastor(@RequestBody PastorCreateDTO pastorDTO){

        return pastorService.save(pastorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PastorCreateDTO> updatePastor(@PathVariable UUID id, @RequestBody PastorCreateDTO pastorDTO) {
        if (!pastorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        PastorCreateDTO updated = pastorService.updatePastor(id, pastorDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePastor(@PathVariable UUID id) {
        if (!pastorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pastorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
