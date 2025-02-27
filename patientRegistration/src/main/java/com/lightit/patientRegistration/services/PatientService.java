package com.lightit.patientRegistration.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lightit.patientRegistration.Api.MailService;
import com.lightit.patientRegistration.models.Patient;
import com.lightit.patientRegistration.models.Notification.Notification;
import com.lightit.patientRegistration.models.Notification.NotificationType;
import com.lightit.patientRegistration.repositories.NotificationRepository;
import com.lightit.patientRegistration.repositories.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    NotificationRepository notificationRepository;

    private MailService mailService;

    public PatientService(MailService mailService) {
        this.mailService = mailService;
    }

    public Patient registerPatient(Patient patient) throws IOException {
        patient.setDocumentPhoto(patient.getDocumentPhoto());
        this.patientRepository.save(patient);
        this.notificationRepository.save(new Notification(patient, NotificationType.REGISTER));
        return patient;
    }

    public void notifyPatients() {
        List<Notification> pendingNotifications = this.notificationRepository.findByNotifiedFalse();
        this.mailService.impactNotifiations(pendingNotifications);
        pendingNotifications.forEach(
            n -> n.setNotified(true)
        );
        this.notificationRepository.saveAll(pendingNotifications);
    }
}
