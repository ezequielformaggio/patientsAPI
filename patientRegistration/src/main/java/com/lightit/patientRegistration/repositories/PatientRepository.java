package com.lightit.patientRegistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lightit.patientRegistration.models.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    
}

