package br.uneb.dcet.si20192.tees.manguebem.api.service;

import br.uneb.dcet.si20192.tees.manguebem.api.repository.SpecieRepository;
import br.uneb.dcet.si20192.tees.manguebemapi.entity.Specie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.uneb.dcet.si20192.tees.manguebem.api.controller.dto.SpecieDTO;

@Service
public class SpecieService {

    private final SpecieRepository specieRepository;

    @Autowired
    public SpecieService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public SpecieDTO create(SpecieDTO specieDTO) {
        // Convert DTO to entity if necessary
        Specie specie = new Specie();
        // Set properties of specie from specieDTO
        specie = specieRepository.save(specie);
        return convertToDTO(specie);
    }

    public SpecieDTO getById(Long id) {
        Optional<Specie> specieOptional = specieRepository.findById(id);
        if (specieOptional.isPresent()) {
            return convertToDTO(specieOptional.get());
        } else {
            return null;
        }
    }

    public List<SpecieDTO> getAll() {
        List<Specie> species = specieRepository.findAll();
        List<SpecieDTO> specieDTOs = new ArrayList<>();
        for (Specie specie : species) {
            specieDTOs.add(convertToDTO(specie));
        }
        return specieDTOs;
    }

    public SpecieDTO update(SpecieDTO specieDTO) {
        // Check if specie exists
        if (specieRepository.existsById(specieDTO.getId())) {
            // Update the specie
            Specie specie = convertToEntity(specieDTO);
            specie = specieRepository.save(specie);
            return convertToDTO(specie);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        // Check if specie exists
        if (specieRepository.existsById(id)) {
            // Delete the specie
            specieRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private SpecieDTO convertToDTO(Specie specie) {
        // Convert Specie entity to SpecieDTO
        SpecieDTO specieDTO = new SpecieDTO();
        // Set properties of specieDTO from specie
        return specieDTO;
    }

    private Specie convertToEntity(SpecieDTO specieDTO) {
        // Convert SpecieDTO to Specie entity
        Specie specie = new Specie();
        // Set properties of specie from specieDTO
        return specie;
    }

}