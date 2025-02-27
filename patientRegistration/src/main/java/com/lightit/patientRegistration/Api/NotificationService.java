package com.lightit.patientRegistration.Api;

import com.lightit.patientRegistration.models.Notification.Notification;

public interface NotificationService {
    void notifyRegistration(Notification notification);
}
