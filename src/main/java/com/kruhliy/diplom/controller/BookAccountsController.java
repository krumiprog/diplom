package com.kruhliy.diplom.controller;

import com.kruhliy.diplom.model.BookAccounts;
import com.kruhliy.diplom.model.RegistrationBook;
import com.kruhliy.diplom.repository.BookAccountsRepository;
import com.kruhliy.diplom.repository.RegistrationBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Controller
@RequestMapping("/kvvj_ks")
public class BookAccountsController {

    @Autowired
    private BookAccountsRepository bookAccountsRepository;
    @Autowired
    private RegistrationBookRepository registrationBookRepository;

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
}
