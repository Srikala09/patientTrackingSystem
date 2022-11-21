package com.example.pts.repository;

import com.example.pts.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface PatientRepository extends CrudRepository<Patient,Integer> {

   Patient findById(Integer id);

}
