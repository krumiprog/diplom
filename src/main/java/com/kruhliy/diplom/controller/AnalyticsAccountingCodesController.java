package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.AnalyticalAccountingCodes;
import com.kruhliy.diplom.model.TypesAnalytics;
import com.kruhliy.diplom.repository.AnalyticalAccountingCodesRepository;
import com.kruhliy.diplom.repository.TypesAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_kau")
public class AnalyticsAccountingCodesController {

    @Autowired
    private AnalyticalAccountingCodesRepository analyticalAccountingCodesRepository;
    @Autowired
    private TypesAnalyticsRepository typesAnalyticsRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<AnalyticalAccountingCodes> codes = analyticalAccountingCodesRepository.findAll();
        model.addAttribute("codes", codes);
        Iterable<TypesAnalytics> types = typesAnalyticsRepository.findAll();
        model.addAttribute("types", types);
        return "kvvj_kau";
    }

    @PostMapping
    public String create(AnalyticalAccountingCodes analyticalAccountingCodes) {
        if (analyticalAccountingCodes.getId() == null && analyticalAccountingCodesRepository.findByKauNAndKauK(
                        analyticalAccountingCodes.getKauN(), analyticalAccountingCodes.getKauK()).isEmpty()) {
            analyticalAccountingCodesRepository.save(analyticalAccountingCodes);
        }
        return "redirect:/kvvj_kau";
    }

    @PostMapping("/update")
    public String update(AnalyticalAccountingCodes analyticalAccountingCodes) {
        if (analyticalAccountingCodes.getId() != null) {
            analyticalAccountingCodesRepository.save(analyticalAccountingCodes);
        }
        return "redirect:/kvvj_kau";
    }

    @PostMapping("/delete")
    public String delete(AnalyticalAccountingCodes analyticalAccountingCodes) {
        Optional<AnalyticalAccountingCodes> byId = analyticalAccountingCodesRepository
                .findById(analyticalAccountingCodes.getId());
        byId.ifPresent(analyticalAccountingCodesRepository::delete);
        return "redirect:/kvvj_kau";
    }
}
