package com.bootcamptoprod.springbootemail.controller;

import com.bootcamptoprod.springbootemail.model.EmailRequest;
import com.bootcamptoprod.springbootemail.service.EmailSenderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailSenderService emailService;

    public EmailController(EmailSenderService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendPlainTextEmail")
    public ResponseEntity<String> sendPlainTextEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendPlainTextEmail(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }

    @PostMapping("/sendEmailWithAttachment")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmailWithAttachment(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }

    @PostMapping("/sendEmailWithHtml")
    public ResponseEntity<String> sendEmailWithHtml(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmailWithHtml(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }

    @PostMapping("/sendEmailWithInlineImages")
    public ResponseEntity<String> sendEmailWithInlineImages(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmailWithInlineImages(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }

    @PostMapping("/sendEmailWithTable")
    public ResponseEntity<String> sendEmailWithTable(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmailWithTable(emailRequest);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email failed to send: " + e.getMessage());
        }
    }
}
