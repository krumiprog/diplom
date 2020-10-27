package com.kruhliy.diplom.service;

import com.kruhliy.diplom.model.SystemSetup;
import com.kruhliy.diplom.repository.SystemSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;

//@Service
//public class SettingsInit implements CommandLineRunner {
//
//    @Autowired
//    private SystemSetupRepository systemSetupRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Date now = new Date();
//        SystemSetup systemSetup = new SystemSetup();
//        systemSetup.setNstDatat(now);
//        systemSetup.setNstDatas(now);
//        systemSetup.setNstDatad(now);
//        systemSetup.setNstS(999);
//        systemSetup.setNstSn("chart");
//        systemSetup.setNstFirma("company");
//        systemSetupRepository.save(systemSetup);
//
//        System.out.println(now);
//    }
//}
