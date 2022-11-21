package com.example.pts.service;
import com.example.pts.model.Patient;
import com.example.pts.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientService {
    @Autowired
    PatientRepository patientRepository ;

    public List<Patient> fetchAllPatients(){
        List<Patient> patients = (List<Patient>)patientRepository.findAll();
        return patients;
    }
    public Patient createPatient(Patient patient)
    {
      return  patientRepository.save(patient);

    }
    public Patient fetchPatientById(Integer id){
        return patientRepository.findById(id);

    }
    public void  persistPatient(Patient patient) {
        patientRepository.save(patient);

    }
    public void  modifyPatient(Patient patient) {

        patientRepository.save(patient);

    }

}
