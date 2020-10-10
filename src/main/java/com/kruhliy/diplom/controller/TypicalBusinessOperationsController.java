package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.TypicalBusinessOperations;
import com.kruhliy.diplom.repository.DefiningPrimaryDocumentsRepository;
import com.kruhliy.diplom.repository.TypesAnalyticsRepository;
import com.kruhliy.diplom.repository.TypicalBusinessOperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_txo")
public class TypicalBusinessOperationsController {

    @Autowired
    private TypicalBusinessOperationsRepository typicalBusinessOperationsRepository;
    @Autowired
    private DefiningPrimaryDocumentsRepository definingPrimaryDocumentsRepository;
    @Autowired
    private TypesAnalyticsRepository typesAnalyticsRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<TypicalBusinessOperations> docs = typicalBusinessOperationsRepository.findAll();
        model.addAttribute("docs", docs);
//        Iterable<TypesAnalytics> types = typesAnalyticsRepository.findAll();
//        model.addAttribute("types", types);
        return "kvvj_txo";
    }

    @PostMapping
    public String create(TypicalBusinessOperations typicalBusinessOperations) {
        if (typicalBusinessOperations.getId() == null) {
            typicalBusinessOperationsRepository.save(typicalBusinessOperations);
        }
        return "redirect:/kvvj_txo";
    }

    @PostMapping("/update")
    public String update(TypicalBusinessOperations typicalBusinessOperations) {
        if (typicalBusinessOperations.getId() != null) {
            typicalBusinessOperationsRepository.save(typicalBusinessOperations);
        }
        return "redirect:/kvvj_txo";
    }

    @PostMapping("/delete")
    public String delete(TypicalBusinessOperations typicalBusinessOperations) {
        Optional<TypicalBusinessOperations> byId = typicalBusinessOperationsRepository
                .findById(typicalBusinessOperations.getId());
        byId.ifPresent(typicalBusinessOperationsRepository::delete);
        return "redirect:/kvvj_txo";
    }
}
