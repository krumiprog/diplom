package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.TypesAnalytics;
import com.kruhliy.diplom.repository.TypesAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_analytics")
public class TypesAnalyticsController {

        @Autowired
        private TypesAnalyticsRepository repository;

        @GetMapping
        public String getForm(Model model) {
            Iterable<TypesAnalytics> types = repository.findAll();
            model.addAttribute("types", types);
            return "kvvj_analytics";
        }

        @PostMapping
        public String createType(TypesAnalytics typesAnalytics) {
            if (repository.findByVaK(typesAnalytics.getVaK()).isEmpty()) {
//            if (repository.findById(typesAnalytics.getId()).isEmpty()) {
                repository.save(typesAnalytics);
            }
            return "redirect:/kvvj_analytics";
        }

        @PostMapping("/update")
        public String updateType(TypesAnalytics typesAnalytics) {
            repository.save(typesAnalytics);
            return "redirect:/kvvj_analytics";
        }

        @PostMapping("/delete")
        public String deleteType(TypesAnalytics typesAnalytics) {
            Optional<TypesAnalytics> byId = repository.findById(typesAnalytics.getId());
            byId.ifPresent(repository::delete);
            return "redirect:/kvvj_analytics";
        }
}
