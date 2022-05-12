package com.example.md4casestudynhom2;

import com.example.md4casestudynhom2.model.DTO.UserPrinciple;
import com.example.md4casestudynhom2.service.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Md4CaseStudyNhom2Application {

//
//    public UserPrinciple userPrinciple;

    public static void main(String[] args) {
        SpringApplication.run(Md4CaseStudyNhom2Application.class, args);
    }

}
