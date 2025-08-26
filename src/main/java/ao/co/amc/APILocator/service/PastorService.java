package ao.co.amc.APILocator.service;

import ao.co.amc.APILocator.model.Pastor;
import ao.co.amc.APILocator.repository.PastorRepository;
import ao.co.amc.APILocator.dto.PastorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PastorService {

    private final PastorRepository pastorRepository;
    private final ModelMapper modelMapper;

    public PastorService(PastorRepository pastorRepository, ModelMapper modelMapper) {
        this.pastorRepository = pastorRepository;
        this.modelMapper = modelMapper;
    }

    public List<PastorDTO> findAllDTO() {
        return pastorRepository.findAll()
                .stream()
                .map(pastor -> modelMapper.map(pastor, PastorDTO.class))
                .toList();
    }

    public Optional<PastorDTO> findById(UUID id) {
        return pastorRepository.findById(id)
                .map(pastor -> modelMapper.map(pastor, PastorDTO.class));
    }

    public Optional<Pastor> findByIdInternal(UUID id) {
        return pastorRepository.findById(id);
    }

    public PastorDTO save(PastorDTO pastorDTO) {
        Pastor pastor = modelMapper.map(pastorDTO, Pastor.class);
        Pastor saved = pastorRepository.save(pastor);
        return modelMapper.map(saved, PastorDTO.class);
    }

    public PastorDTO updatePastor(UUID id, PastorDTO pastorDTO) {
        Pastor entity = modelMapper.map(pastorDTO, Pastor.class);
        entity.setId(id);
        Pastor updated = pastorRepository.save(entity);
        return modelMapper.map(updated, PastorDTO.class);
    }

    public void deleteById(UUID id) {
        pastorRepository.deleteById(id);
    }
}
