package com.kruhliy.diplom.service;

import com.kruhliy.diplom.model.SystemSetup;
import com.kruhliy.diplom.repository.SystemSetupRepository;
import com.kruhliy.diplom.security.model.Role;
import com.kruhliy.diplom.security.model.User;
import com.kruhliy.diplom.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

// Используется для первоночальной инициализации пользователей admin, user
// Преред первой компиляцией и запуском раскомментировать, при последующии закомментировать

//@Service
//public class SettingsInit implements CommandLineRunner {
//
//    @Autowired
//    private SystemSetupRepository systemSetupRepository;
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        User admin = new User();
//        admin.setUsername("admin");
//        admin.setPassword(passwordEncoder.encode("admin"));
////        admin.setRoles(Arrays.stream(Role.values()).collect(Collectors.toSet()));
//        admin.setRoles(Set.of(Role.ADMIN));
//        userRepository.save(admin);
//
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword(passwordEncoder.encode("user"));
//        user.setRoles(Set.of(Role.USER));
//        userRepository.save(user);
//
//        Date now = new Date();
//        SystemSetup systemSetup = new SystemSetup();
//        systemSetup.setNstDatat(now);
//        systemSetup.setNstDatas(now);
//        systemSetup.setNstDatad(now);
//        systemSetup.setNstS(999);
//        systemSetup.setNstSn("chart");
//        systemSetup.setNstFirma("company");
//        systemSetupRepository.save(systemSetup);
//    }
//}
