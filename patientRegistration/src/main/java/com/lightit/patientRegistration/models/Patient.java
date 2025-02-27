package com.lightit.patientRegistration.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "Name must contain only letters and spaces.")
    private String name;

    @NotNull
    @Email(message = "Email address must contain a valid format")
    private String emailAddress;

    @NotNull
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "PhoneNumber must contain a valid format")
    private String phoneNumber;

    @NotNull
    @Lob
    private byte[] documentPhoto;

    public Patient() {
    }



    public Patient(String name,String emailAddress,String phoneNumber,byte[] documentPhoto) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.documentPhoto = documentPhoto;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getDocumentPhoto() {
        return documentPhoto;
    }

    public void setDocumentPhoto(byte[] documentPhoto) {
        this.documentPhoto = documentPhoto;
    }

}
