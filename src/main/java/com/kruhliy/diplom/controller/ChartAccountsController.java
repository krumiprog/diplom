package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.ChartAccounts;
import com.kruhliy.diplom.model.TypesAnalytics;
import com.kruhliy.diplom.repository.ChartAccountsRepository;
import com.kruhliy.diplom.repository.TypesAnalyticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_ps")
public class ChartAccountsController {

    @Autowired
    private ChartAccountsRepository chartAccountsRepository;
    @Autowired
    private TypesAnalyticsRepository typesAnalyticsRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<ChartAccounts> charts = chartAccountsRepository.findAll();
        Iterable<TypesAnalytics> types = typesAnalyticsRepository.findAll();
        model.addAttribute("tables", charts);
        model.addAttribute("types", types);
        return "kvvj_ps";
    }

    @PostMapping
    public String create(ChartAccounts chartAccounts) {
        if (chartAccounts.getId() == null) {
            chartAccountsRepository.save(chartAccounts);
        }
        return "redirect:/kvvj_ps";
    }

    @PostMapping("/update")
    public String update(ChartAccounts chartAccounts) {
        if (chartAccounts.getId() != null) {
            chartAccountsRepository.save(chartAccounts);
        }
        return "redirect:/kvvj_ps";
    }

    @PostMapping("/delete")
    public String delete(ChartAccounts chartAccounts) {
        Optional<ChartAccounts> byId = chartAccountsRepository
                .findById(chartAccounts.getId());
        byId.ifPresent(chartAccountsRepository::delete);
        return "redirect:/kvvj_ps";
    }
}
