package ao.co.amc.APILocator.service;

import ao.co.amc.APILocator.model.Church;
import ao.co.amc.APILocator.model.Pastor;
import ao.co.amc.APILocator.repository.ChurchRepository;
import jakarta.transaction.Transactional;
import ao.co.amc.APILocator.dto.ChurchCreateDTO;
import ao.co.amc.APILocator.dto.ChurchResponseDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChurchService {

    private final ChurchRepository churchRepository;

    private final ModelMapper modelMapper;

    private final PastorService pastorService;

    public ChurchService(ChurchRepository churchRepository, ModelMapper modelMapper, PastorService pastorService) {
        this.churchRepository = churchRepository;
        this.modelMapper = modelMapper;
        this.pastorService = pastorService;
    }

    public List<ChurchCreateDTO> findAllDTO() {
        return churchRepository.findAll()
                .stream()
                .map(church -> modelMapper.map(church, ChurchCreateDTO.class))
                .toList();
    }

    public Optional<ChurchCreateDTO> findById(UUID id) {
        return churchRepository.findById(id)
                .map(church -> modelMapper.map(church, ChurchCreateDTO.class));
    }

    @Transactional
    public ChurchResponseDTO save(ChurchCreateDTO churchDTO) {
        Church church = modelMapper.map(churchDTO, Church.class);
        church.setId(null);

        var pastorOpt = pastorService.findByIdInternal(churchDTO.getPastorId());
        pastorOpt.ifPresent(pastor -> church.setPastor(pastor));

        Church saved = churchRepository.save(church);
        return modelMapper.map(saved, ChurchResponseDTO.class);
    }

    public ChurchCreateDTO updateChurch(UUID id, ChurchCreateDTO churchDTO) {

        Church entity = modelMapper.map(churchDTO, Church.class);
        entity.setId(id);
        Church updated = churchRepository.save(entity);
        return modelMapper.map(updated, ChurchCreateDTO.class);
    }

    public void deleteById(UUID id) {
        churchRepository.deleteById(id);
    }
}
