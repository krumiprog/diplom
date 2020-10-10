package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.RegistrationBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationBookRepository extends CrudRepository<RegistrationBook, Long> {
}
