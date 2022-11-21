package com.example.pts.controller;
import com.example.pts.dto.PatientDto;
import com.example.pts.model.Patient;
import com.example.pts.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.lang.String;
@RestController
//@CrossOrigin(origins = "http://localhost:8082")

@RequestMapping()
public class PatientController {
    @Autowired
    PatientService patientService ;
    PatientDto patientDto;
    ModelMapper modelMapper = new ModelMapper() ;
    public PatientController()
    {}
    @GetMapping(value = "/patient/all" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<PatientDto> fetchAllPatients() {
        System.out.println("In controller...");
        List<Patient> patientList =  patientService.fetchAllPatients();
        List<PatientDto> patients = Arrays.asList(modelMapper.map(patientList,PatientDto[].class));
        return patients ;
    }

    @GetMapping(value = "/patient/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
    public PatientDto fetchPatientById(@PathVariable("id") Integer id) {
        System.out.println("Fetching patients by id ...");
        Patient patient =  patientService.fetchPatientById(id);
        PatientDto  patientDto = modelMapper.map(patient,PatientDto.class);
        return patientDto ;
    }
    @PostMapping(value = "/patient/create",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String>  createPatient(@RequestBody PatientDto patientDto) {
        System.out.println("name of the Patients=="+patientDto.getName());
        Patient patient = modelMapper.map(patientDto,Patient.class);
        patientService.createPatient(patient);
        patientService.persistPatient(patient);
        return ResponseEntity.ok().body("Patient Details Registered Successfully.");
    }
 /*  @PostMapping(value = "/patient/create",produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<String>  createPatient(@RequestBody PatientDto patientDto) {
       System.out.println("name of the Patients=="+patientDto.getName());
       Patient patient = modelMapper.map(patientDto,Patient.class);
       patientService.createPatient(patient);
       patientService.persistPatient(patient);
       return ResponseEntity.ok().body("Patient Details Registered Successfully.");
      // return new ResponseEntity<Patient>(patientService.createPatient(patient), HttpStatus.CREATED);
   }*/
    @PutMapping(value = "/patient/update",produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity<String>  updatePatient(@RequestBody PatientDto patientDto) {
        Patient patient  = patientService.fetchPatientById(patientDto.getId());
        patientService.modifyPatient(generatePatient(patientDto,patient));
        return ResponseEntity.ok().body("Patient Details Modified Successfully.");
    }
    private Patient  generatePatient(PatientDto patientDto,Patient patient) {

        patient.setId(patientDto.getId());
        patient.setBp(patientDto.getBp());
        patient.setAge(patientDto.getAge());
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setMaritalstatus(patientDto.getMaritalstatus());
        patient.setMobile(patientDto.getMobile());
        patient.setFullname(patientDto.getFullname());
        patient.setCity(patientDto.getCity());
        patient.setDistrict(patientDto.getDistrict());
        patient.setState(patientDto.getState());
        patient.setZipcode(patientDto.getZipcode());
        patient.setTemperature(patientDto.getTemperature());
        patient.setBloodgroup(patientDto.getBloodgroup());
        patient.setHeight(patientDto.getHeight());
        patient.setWeight(patientDto.getWeight());
        patient.setConsultngdoctor(patientDto.getConsultngdoctor());
        patient.setHabits(patientDto.getHabits());
        patient.setTypeofPatient(patientDto.getTypeofPatient());
        return patient ;
    }

}
