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
@RequestMapping("/kvvj_va")
public class TypesAnalyticsController {

        @Autowired
        private TypesAnalyticsRepository typesAnalyticsRepository;

        @GetMapping
        public String getForm(Model model) {
            Iterable<TypesAnalytics> types = typesAnalyticsRepository.findAll();
            model.addAttribute("types", types);
            return "kvvj_va";
        }

        @PostMapping
        public String createType(TypesAnalytics typesAnalytics) {
            if (typesAnalytics.getId() == null
                    && typesAnalyticsRepository.findByVaK(typesAnalytics.getVaK()).isEmpty()) {
                typesAnalyticsRepository.save(typesAnalytics);
            }
            return "redirect:/kvvj_va";
        }

        @PostMapping("/update")
        public String updateType(TypesAnalytics typesAnalytics) {
            if (typesAnalytics.getId() != null) {
                typesAnalyticsRepository.save(typesAnalytics);
            }
            return "redirect:/kvvj_va";
        }

        @PostMapping("/delete")
        public String deleteType(TypesAnalytics typesAnalytics) {
            Optional<TypesAnalytics> byId = typesAnalyticsRepository.findById(typesAnalytics.getId());
            byId.ifPresent(typesAnalyticsRepository::delete);
            return "redirect:/kvvj_va";
        }
}
