package com.lightit.patientRegistration.Api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.lightit.patientRegistration.models.Notification.Notification;

@Service
public class MailService implements NotificationService {

	@Autowired
    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Async
	public void notifyRegistration(Notification notification) {

      SimpleMailMessage msg = new SimpleMailMessage();
		  msg.setFrom("registers@patients.com");
	      msg.setTo(notification.getPatient().getEmailAddress());
		  msg.setSubject(notification.getType().toString());
		  msg.setText(
		  		"Dear " + notification.getPatient().getName() +
                ", thank you for registering in Patient Registration App. We appreciate your trust in our services."
            );

		  try {
		  	this.mailSender.send(msg);
		  }
		  catch (MailException ex) {
		  	System.err.println(ex.getMessage());
		  }

    }

	public void impactNotifiations(List<Notification> notifications) {
		notifications.forEach(
			notification -> notifyRegistration(notification)
		);
	}
}
