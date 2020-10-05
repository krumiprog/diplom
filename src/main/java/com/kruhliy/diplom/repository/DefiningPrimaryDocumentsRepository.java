package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.DefiningPrimaryDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefiningPrimaryDocumentsRepository extends JpaRepository<DefiningPrimaryDocuments, Long> {
}
