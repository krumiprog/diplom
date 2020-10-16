package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.RegistrationBook;
import com.kruhliy.diplom.repository.RegistrationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/kvvj_rj")
public class RegistrationBookRestController {

    @Autowired
    private RegistrationBookRepository registrationBookRepository;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody RegistrationBook registrationBook) {
//        System.out.println("===========" + registrationBook);

        if (registrationBook.getId() == null) {
            registrationBookRepository.save(registrationBook);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
//        System.out.println("------------ delete all");

        registrationBookRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }



//    @PostMapping("/hello")
//    public ResponseEntity<?> create(@RequestBody String hello) {
//        System.out.println("=========== " + hello);
//
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
