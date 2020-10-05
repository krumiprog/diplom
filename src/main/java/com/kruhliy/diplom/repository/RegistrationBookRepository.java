package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.RegistrationBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationBookRepository extends JpaRepository<RegistrationBook, Long> {
}
