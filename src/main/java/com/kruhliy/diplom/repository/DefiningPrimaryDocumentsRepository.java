package com.kruhliy.diplom.repository;

import com.kruhliy.diplom.model.DefiningPrimaryDocuments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefiningPrimaryDocumentsRepository extends CrudRepository<DefiningPrimaryDocuments, Long> {
}
