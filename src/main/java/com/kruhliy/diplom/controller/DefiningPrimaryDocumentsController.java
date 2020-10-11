package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.DefiningPrimaryDocuments;
import com.kruhliy.diplom.model.TypesAnalytics;
import com.kruhliy.diplom.repository.DefiningPrimaryDocumentsRepository;
import com.kruhliy.diplom.repository.TypesAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_opd")
public class DefiningPrimaryDocumentsController {

    @Autowired
    private DefiningPrimaryDocumentsRepository definingPrimaryDocumentsRepository;
    @Autowired
    private TypesAnalyticsRepository typesAnalyticsRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<DefiningPrimaryDocuments> docs = definingPrimaryDocumentsRepository.findAll();
        Iterable<TypesAnalytics> types = typesAnalyticsRepository.findAll();
        model.addAttribute("tables", docs);
        model.addAttribute("types", types);
        return "kvvj_opd";
    }

    @PostMapping
    public String create(DefiningPrimaryDocuments definingPrimaryDocuments) {
        if (definingPrimaryDocuments.getId() == null) {
            definingPrimaryDocumentsRepository.save(definingPrimaryDocuments);
        }
        return "redirect:/kvvj_opd";
    }

    @PostMapping("/update")
    public String update(DefiningPrimaryDocuments definingPrimaryDocuments) {
        if (definingPrimaryDocuments.getId() != null) {
            definingPrimaryDocumentsRepository.save(definingPrimaryDocuments);
        }
        return "redirect:/kvvj_opd";
    }

    @PostMapping("/delete")
    public String delete(DefiningPrimaryDocuments definingPrimaryDocuments) {
        Optional<DefiningPrimaryDocuments> byId = definingPrimaryDocumentsRepository
                .findById(definingPrimaryDocuments.getId());
        byId.ifPresent(definingPrimaryDocumentsRepository::delete);
        return "redirect:/kvvj_opd";
    }
}
