package ao.co.amc.APILocator.service;

import ao.co.amc.APILocator.model.Pastor;
import ao.co.amc.APILocator.repository.PastorRepository;
import ao.co.amc.APILocator.dto.PastorCreateDTO;
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

    public List<PastorCreateDTO> findAllDTO() {
        return pastorRepository.findAll()
                .stream()
                .map(pastor -> modelMapper.map(pastor, PastorCreateDTO.class))
                .toList();
    }

    public Optional<PastorCreateDTO> findById(UUID id) {
        return pastorRepository.findById(id)
                .map(pastor -> modelMapper.map(pastor, PastorCreateDTO.class));
    }

    public Optional<Pastor> findByIdInternal(UUID id) {
        return pastorRepository.findById(id);
    }

    public PastorCreateDTO save(PastorCreateDTO pastorDTO) {
        Pastor pastor = modelMapper.map(pastorDTO, Pastor.class);
        Pastor saved = pastorRepository.save(pastor);
        return modelMapper.map(saved, PastorCreateDTO.class);
    }

    public PastorCreateDTO updatePastor(UUID id, PastorCreateDTO pastorDTO) {
        Pastor entity = modelMapper.map(pastorDTO, Pastor.class);
        entity.setId(id);
        Pastor updated = pastorRepository.save(entity);
        return modelMapper.map(updated, PastorCreateDTO.class);
    }

    public void deleteById(UUID id) {
        pastorRepository.deleteById(id);
    }
}
