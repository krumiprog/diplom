package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.ChartAccounts;
import com.kruhliy.diplom.model.SystemSetup;
import com.kruhliy.diplom.repository.ChartAccountsRepository;
import com.kruhliy.diplom.repository.SystemSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/kvvj_nst")
public class SystemSetupController {

    @Autowired
    private SystemSetupRepository systemSetupRepository;
    @Autowired
    private ChartAccountsRepository chartAccountsRepository;

    @GetMapping("/kvvj_nst_si")
    public String getFormInterval(Model model) {
        Iterable<ChartAccounts> charts = chartAccountsRepository.findAll();
        model.addAttribute("charts", charts);
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            model.addAttribute("dateS", interval.get().getNstDatas());
            model.addAttribute("dateD", interval.get().getNstDatad());
            model.addAttribute("nstS", interval.get().getNstS());
            model.addAttribute("nstSn", interval.get().getNstSn());
        }
        return "kvvj_nst_si";
    }

    @PostMapping("/kvvj_nst_si")
    public String setInterval(SystemSetup systemSetup) {
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            interval.get().setNstDatas(systemSetup.getNstDatas());
            interval.get().setNstDatad(systemSetup.getNstDatad());
            interval.get().setNstS(systemSetup.getNstS());
            interval.get().setNstSn(systemSetup.getNstSn());
            systemSetupRepository.save(interval.get());
        }
        return "redirect:/kvvj_nst/kvvj_nst_si";
    }

    @GetMapping("/kvvj_nst_st")
    public String getFormCurDate(Model model) {
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            model.addAttribute("nstDatat", interval.get().getNstDatat());
        }
        return "kvvj_nst_st";
    }

    @PostMapping("/kvvj_nst_st")
    public String setCurDate(SystemSetup systemSetup) {
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            interval.get().setNstDatat(systemSetup.getNstDatat());
            systemSetupRepository.save(interval.get());
        }
        return "redirect:/kvvj_nst/kvvj_nst_st";
    }

    @GetMapping("/kvvj_nst_sf")
    public String getFormNameCompany(Model model) {
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            model.addAttribute("nstFirma", interval.get().getNstFirma());
        }
        return "kvvj_nst_sf";
    }

    @PostMapping("/kvvj_nst_sf")
    public String setNameCompany(SystemSetup systemSetup) {
        Optional<SystemSetup> interval = systemSetupRepository.findById(1L);
        if (interval.isPresent()) {
            interval.get().setNstFirma(systemSetup.getNstFirma());
            systemSetupRepository.save(interval.get());
        }
        return "redirect:/kvvj_nst/kvvj_nst_sf";
    }
}
