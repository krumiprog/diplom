package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.PrimaryDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryDocumentsRepository extends JpaRepository<PrimaryDocuments, Long> {
}
