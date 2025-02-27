# Patient Registration


This application provides an API to register patients in our healthcare system. 
Once patients are registered, a notification will eventually be sent via email to confirm the registration.

## Content table

1. [Features](#features)
2. [Requirements](#requirements)
3. [Installation](#installation)
4. [API Endpoints](#api-endpoints)

## Features

- Register patients by providing the necessary details and ensuring the correct data format.
- Send email notifications to confirm registration.
- API built using Java and Spring Boot.

## Requirements

### System Requirements

- JDK 11 or higher
- Maven 3.6 or higher 
- Docker (if you want to run the application in a container)
- Postman ([postman collection](./patientRegistration/postman/Patients.postman_collection.json))

### Dependencies and technologies

- Spring Boot
- Spring Data JPA 
- Spring Mail
- Spring validarion
- MySQL
- Java 17
- Mailtrap service
- Docker
- Postman (for testing )

## Installation

1. **Clone the repository:**
   ```bash
   git clone git@github.com:ezequielformaggio/patientsAPI.git

2. **Setting credentials:**
  Once the repository is cloned, edit the [docker-compose](./patientRegistration/docker-compose.yml) file and set your Mailtrap credentials to receive emails from the application.

      ```docker-compose.yml
      SPRING_MAIL_USERNAME: your-username-here
      SPRING_MAIL_PASSWORD: your-password-here
      ```
3. **Running the application with Docker:**
When the credentials are set, open a terminal and run
      ```bash
      docker-compose up --build
      ```
## Endpoints

### POST /patient

**Description:**  
Registers a new patient in the system.

**Request Body:**
example:
```json
{
  "name": "John Doe",
  "phoneNumber": "+1122334455",
  "email": "johndoe@example.com",
  "documentPhoto": "base64-encoded-photo"
}
```
### PATCH /patient/notify

**Description:**  
Notifies the registration event for new patients.
