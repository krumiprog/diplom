package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.*;
import com.kruhliy.diplom.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_pd")
public class PrimaryDocumentsController {

    @Autowired
    private PrimaryDocumentsRepository primaryDocumentsRepository;
    @Autowired
    private DefiningPrimaryDocumentsRepository definingPrimaryDocumentsRepository;
    @Autowired
    private AnalyticalAccountingCodesRepository analyticalAccountingCodesRepository;
    @Autowired
    private TypicalBusinessOperationsRepository typicalBusinessOperationsRepository;
    @Autowired
    private RegistrationBookRepository registrationBookRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<PrimaryDocuments> primaryDocs = primaryDocumentsRepository.findAll();
        Iterable<DefiningPrimaryDocuments> defPrimDocs = definingPrimaryDocumentsRepository.findAll();
        Iterable<AnalyticalAccountingCodes> codes = analyticalAccountingCodesRepository.findAll();
        Iterable<TypicalBusinessOperations> typBusOpers = typicalBusinessOperationsRepository.findAll();
        Iterable<RegistrationBook> regBook = registrationBookRepository.findAll();
        model.addAttribute("tables", primaryDocs);
        model.addAttribute("defPrimDocs", defPrimDocs);
        model.addAttribute("codes", codes);
        model.addAttribute("operations", typBusOpers);
        model.addAttribute("books", regBook);
        return "kvvj_pd";
    }

    @PostMapping
    public String create(PrimaryDocuments primaryDocuments) {
        if (primaryDocuments.getId() == null) {
            primaryDocumentsRepository.save(primaryDocuments);
        }
        return "redirect:/kvvj_pd";
    }

    @PostMapping("/update")
    public String update(PrimaryDocuments primaryDocuments) {
        if (primaryDocuments.getId() != null) {
            primaryDocumentsRepository.save(primaryDocuments);
        }
        return "redirect:/kvvj_pd";
    }

    @PostMapping("/delete")
    public String delete(PrimaryDocuments primaryDocuments) {
        Optional<PrimaryDocuments> byId = primaryDocumentsRepository
                .findById(primaryDocuments.getId());
        byId.ifPresent(primaryDocumentsRepository::delete);
        return "redirect:/kvvj_pd";
    }
}
