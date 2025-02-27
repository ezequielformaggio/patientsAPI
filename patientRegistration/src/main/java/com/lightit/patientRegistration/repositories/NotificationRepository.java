package com.lightit.patientRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lightit.patientRegistration.models.Notification.Notification;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {
    List<Notification> findByNotifiedFalse();
}
