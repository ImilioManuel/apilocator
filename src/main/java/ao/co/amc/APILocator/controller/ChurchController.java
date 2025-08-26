package ao.co.amc.APILocator.controller;

import ao.co.amc.APILocator.dto.ChurchCreateDTO;
import ao.co.amc.APILocator.service.ChurchService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/churches")
public class ChurchController {

    private final ChurchService churchService;

    public ChurchController(ChurchService churchService) {
        this.churchService = churchService;
    }

    @GetMapping
    public List<ChurchCreateDTO> getAllChurches() {
        return churchService.findAllDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChurchCreateDTO> findById(@PathVariable UUID id) {
        return churchService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ChurchCreateDTO createChurch(@RequestBody ChurchCreateDTO churchDTO){
        return churchService.save(churchDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChurchCreateDTO> updateChurch(@PathVariable UUID id, @RequestBody ChurchCreateDTO churchDTO) {
        if (!churchService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(churchService.updateChurch(id, churchDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChurch(@PathVariable UUID id) {
        if (!churchService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        churchService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
