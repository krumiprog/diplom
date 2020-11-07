package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.BookAccounts;
import com.kruhliy.diplom.model.RegistrationBook;
import com.kruhliy.diplom.model.SystemSetup;
import com.kruhliy.diplom.repository.BookAccountsRepository;
import com.kruhliy.diplom.repository.RegistrationBookRepository;
import com.kruhliy.diplom.repository.SystemSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kvvj_ks")
public class BookAccountsController {

    @Autowired
    private BookAccountsRepository bookAccountsRepository;
    @Autowired
    private RegistrationBookRepository registrationBookRepository;
    @Autowired
    private SystemSetupRepository systemSetupRepository;

    @GetMapping
    public String getForm(Model model) {
        Iterable<BookAccounts> bookAccounts = bookAccountsRepository.findAll();
        model.addAttribute("tables", bookAccounts);
        return "kvvj_ks";
    }

    @GetMapping("kvvj_ks_create")
    public String createBooks() {
        bookAccountsRepository.deleteAll();
        Iterable<RegistrationBook> all = registrationBookRepository.findAll();
        if (all.iterator().hasNext()) {
            all.forEach(item -> {
                BookAccounts bookAccounts = new BookAccounts();
                bookAccounts.setKsData(item.getRjData());
                bookAccounts.setKsDokk(item.getRjDokk());
                bookAccounts.setKsDokn(item.getRjDokn());
                bookAccounts.setKsDokd(item.getRjDokd());
                bookAccounts.setKsTo(item.getRjTo());
                bookAccounts.setKsS(item.getRjDb());
                bookAccounts.setKsSn(item.getRjDbn());
                bookAccounts.setKsKs(item.getRjKr());
                bookAccounts.setKsKsn(item.getRjKrn());
                bookAccounts.setKsDb(item.getRjRub());
                bookAccounts.setKsKr(0);
                bookAccountsRepository.save(bookAccounts);

                BookAccounts bookAccounts1 = new BookAccounts();
                bookAccounts1.setKsData(item.getRjData());
                bookAccounts1.setKsDokk(item.getRjDokk());
                bookAccounts1.setKsDokn(item.getRjDokn());
                bookAccounts1.setKsDokd(item.getRjDokd());
                bookAccounts1.setKsTo(item.getRjTo());
                bookAccounts1.setKsS(item.getRjKr());
                bookAccounts1.setKsSn(item.getRjKrn());
                bookAccounts1.setKsKs(item.getRjDb());
                bookAccounts1.setKsKsn(item.getRjDbn());
                bookAccounts1.setKsDb(0);
                bookAccounts1.setKsKr(item.getRjRub());
                bookAccountsRepository.save(bookAccounts1);
            });
        }
        return "redirect:/";
    }

    @GetMapping("kvvj_ks_qx")
    public String getBookForPrint(Model model) {
        Iterable<BookAccounts> all = bookAccountsRepository.findAll();
        model.addAttribute("tables", all);
        return "kvvj_ks_qx";
    }

    @GetMapping("kvvj_ks_qo")
    public String getCapitalBalanceSheet(Model model) {
        Optional<SystemSetup> sysSetup = systemSetupRepository.findById(1L);
        if (sysSetup.isPresent()) {
            model.addAttribute("nstS", sysSetup.get().getNstS());
            model.addAttribute("nstDatas", sysSetup.get().getNstDatas());
            model.addAttribute("nstDatad", sysSetup.get().getNstDatad());

            List<BookAccounts> allByKsSAndKsDataBetween = bookAccountsRepository.findAllByKsSAndKsDataBetween(
                    sysSetup.get().getNstS(), sysSetup.get().getNstDatas(), sysSetup.get().getNstDatad());
            model.addAttribute("tables", allByKsSAndKsDataBetween);

            Integer ksDbSum = allByKsSAndKsDataBetween.stream().mapToInt(BookAccounts::getKsDb).sum();
            Integer ksKrSum = allByKsSAndKsDataBetween.stream().mapToInt(BookAccounts::getKsKr).sum();
            model.addAttribute("ksDbSum", ksDbSum);
            model.addAttribute("ksKrSum", ksKrSum);
        }
        return "kvvj_ks_qo";
    }

    @GetMapping("kvvj_ks_qj")
    public String getOrderLog(Model model) {
        Optional<SystemSetup> sysSetup = systemSetupRepository.findById(1L);
        if (sysSetup.isPresent()) {
            model.addAttribute("nstS", sysSetup.get().getNstS());
            model.addAttribute("nstDatas", sysSetup.get().getNstDatas());
            model.addAttribute("nstDatad", sysSetup.get().getNstDatad());

            String[][] allUtilities = bookAccountsRepository.findOrderLog(
                    sysSetup.get().getNstS(), sysSetup.get().getNstDatas(), sysSetup.get().getNstDatad());
            model.addAttribute("tables", allUtilities);

            int ksKrSum = 0;
            for (String[] str : allUtilities) {
                ksKrSum += Integer.parseInt(str[2]);
            }
            model.addAttribute("ksKrSum", ksKrSum);
        }
        return "kvvj_ks_qj";
    }

    @GetMapping("kvvj_ks_qv")
    public String getBalanceSheet(Model model) {
        Optional<SystemSetup> sysSetup = systemSetupRepository.findById(1L);
        if (sysSetup.isPresent()) {
            model.addAttribute("nstS", sysSetup.get().getNstS());
            model.addAttribute("nstDatas", sysSetup.get().getNstDatas());
            model.addAttribute("nstDatad", sysSetup.get().getNstDatad());

            String[][] allUtilities = bookAccountsRepository.findBalanceSheet(
                    sysSetup.get().getNstS(), sysSetup.get().getNstDatas(), sysSetup.get().getNstDatad());
            model.addAttribute("tables", allUtilities);

            int ksDbSum = 0;
            for (String[] str : allUtilities) {
                ksDbSum += Integer.parseInt(str[2]);
            }
            model.addAttribute("ksDbSum", ksDbSum);
        }
        return "kvvj_ks_qv";
    }
}
