package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.RegistrationBook;
import com.kruhliy.diplom.model.SystemSetup;
import com.kruhliy.diplom.repository.RegistrationBookRepository;
import com.kruhliy.diplom.repository.SystemSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/kvvj_rj")
public class RegistrationBookRestController {

    @Autowired
    private RegistrationBookRepository registrationBookRepository;
    @Autowired
    private SystemSetupRepository systemSetupRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody RegistrationBook registrationBook) {
        if (registrationBook.getId() == null) {
            Optional<SystemSetup> setting = systemSetupRepository.findById(1L);
            if (setting.isPresent()) {
                registrationBook.setRjData(setting.get().getNstDatat());
                registrationBookRepository.save(registrationBook);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        registrationBookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
