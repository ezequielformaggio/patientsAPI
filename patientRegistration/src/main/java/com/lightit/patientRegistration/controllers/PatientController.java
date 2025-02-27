package com.lightit.patientRegistration.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lightit.patientRegistration.models.Patient;
import com.lightit.patientRegistration.services.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Patient> registerPatient(@Valid
        @RequestPart("name") String name,
        @RequestPart("emailAddress") String emailAddress,
        @RequestPart("phoneNumber") String phoneNumber,
        @RequestPart("documentPhoto") MultipartFile documentPhoto) throws IOException {

        Patient patient = new Patient();
        patient.setName(name);
        patient.setEmailAddress(emailAddress);
        patient.setPhoneNumber(phoneNumber);
        patient.setDocumentPhoto(documentPhoto.getBytes());
        Patient newPatient =  this.patientService.registerPatient(patient);
        return ResponseEntity.ok(newPatient);
    }

    @PatchMapping(path="/notify")
    public ResponseEntity<Void> notifyPatients() {
        this.patientService.notifyPatients();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
