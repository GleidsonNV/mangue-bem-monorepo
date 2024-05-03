package br.uneb.dcet.si20192.tees.manguebem.api.controller;

import br.uneb.dcet.si20192.tees.manguebem.api.controller.dto.AuthenticationTokenDTO;
import br.uneb.dcet.si20192.tees.manguebem.api.controller.dto.SpecieDTO;
import br.uneb.dcet.si20192.tees.manguebem.api.controller.dto.UserLoginDTO;
import br.uneb.dcet.si20192.tees.manguebem.api.controller.dto.UserRegistrationDTO;
import br.uneb.dcet.si20192.tees.manguebem.api.service.SpecieService;
import br.uneb.dcet.si20192.tees.manguebem.api.service.UserService;
import br.uneb.dcet.si20192.tees.manguebemapi.entity.Specie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/specie")
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    // CREATE - POST
    @PostMapping
    public ResponseEntity<SpecieDTO> create(@RequestBody SpecieDTO specieDTO) {
        SpecieDTO createdSpecie = specieService.create(specieDTO);
        return new ResponseEntity<Specie>(createdSpecie, HttpStatus.CREATED);
    }

    // READ - GET
    @GetMapping("/{id}")
    public ResponseEntity<SpecieDTO> getById(@PathVariable Long id) {
        SpecieDTO specieDTO = specieService.getById(id);
        if (specieDTO != null) {
            return new ResponseEntity<>(specieDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
//    @GetMapping
//    public ResponseEntity<List<SpecieDTO>> getAll() {
//        List<SpecieDTO> allSpecies = specieService.getAll();
//        return new ResponseEntity<>(allSpecies, HttpStatus.OK);
//    }
//
//    // UPDATE - PUT
//    @PutMapping("/{id}")
//    public ResponseEntity<SpecieDTO> update(@PathVariable Long id, @RequestBody SpecieDTO specieDTO) {
//        specieDTO.setId(id); // Make sure the ID in the DTO matches the ID in the path
//        SpecieDTO updatedSpecie = specieService.update(specieDTO);
//        if (updatedSpecie != null) {
//            return new ResponseEntity<>(updatedSpecie, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        boolean deleted = specieService.delete(id);
//        if (deleted) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}