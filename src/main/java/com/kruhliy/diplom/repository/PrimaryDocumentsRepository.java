package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.PrimaryDocuments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryDocumentsRepository extends CrudRepository<PrimaryDocuments, Long> {
}
