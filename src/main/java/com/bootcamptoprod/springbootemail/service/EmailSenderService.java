package com.bootcamptoprod.springbootemail.service;

import com.bootcamptoprod.springbootemail.model.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendPlainTextEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRequest.getFrom());
        message.setTo(emailRequest.getTo());
        message.setCc(emailRequest.getCc());
        message.setBcc(emailRequest.getBcc());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());

        mailSender.send(message);
    }

    public void sendEmailWithAttachment(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(emailRequest.getFrom());
        mimeMessageHelper.setTo(emailRequest.getTo());
        mimeMessageHelper.setCc(emailRequest.getCc());
        mimeMessageHelper.setBcc(emailRequest.getBcc());
        mimeMessageHelper.setSubject(emailRequest.getSubject());
        mimeMessageHelper.setText(emailRequest.getText());

        FileSystemResource file = new FileSystemResource(new File(emailRequest.getAttachmentPath()));
        mimeMessageHelper.addAttachment(file.getFilename(), file);

        mailSender.send(message);
    }

    public void sendEmailWithHtml(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(emailRequest.getFrom());
        mimeMessageHelper.setTo(emailRequest.getTo());
        mimeMessageHelper.setCc(emailRequest.getCc());
        mimeMessageHelper.setBcc(emailRequest.getBcc());
        mimeMessageHelper.setSubject(emailRequest.getSubject());
        mimeMessageHelper.setText(emailRequest.getText(), true);

        mailSender.send(message);
    }

    public void sendEmailWithInlineImages(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(emailRequest.getFrom());
        mimeMessageHelper.setTo(emailRequest.getTo());
        mimeMessageHelper.setCc(emailRequest.getCc());
        mimeMessageHelper.setBcc(emailRequest.getBcc());
        mimeMessageHelper.setSubject(emailRequest.getSubject());
        mimeMessageHelper.setText(emailRequest.getText(), true);

        FileSystemResource inlineImage1 = new FileSystemResource(new File(emailRequest.getInlineImagesPath().get(0)));
        mimeMessageHelper.addInline("inlineImage1", inlineImage1);

        FileSystemResource inlineImage2 = new FileSystemResource(new File(emailRequest.getInlineImagesPath().get(1)));
        mimeMessageHelper.addInline("inlineImage2", inlineImage2);

        mailSender.send(message);
    }

    public void sendEmailWithTable(EmailRequest emailRequest) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(emailRequest.getFrom());
        mimeMessageHelper.setTo(emailRequest.getTo());
        mimeMessageHelper.setCc(emailRequest.getCc());
        mimeMessageHelper.setBcc(emailRequest.getBcc());
        mimeMessageHelper.setSubject(emailRequest.getSubject());

        StringBuilder html = new StringBuilder();
        html.append("<p>").append(emailRequest.getText()).append("</p>");
        html.append("<table border='1'>");
        for (List<String> row : emailRequest.getTableData()) {
            html.append("<tr>");
            for (String cell : row) {
                html.append("<td>").append(cell).append("</td>");
            }
            html.append("</tr>");
        }
        html.append("</table>");

        mimeMessageHelper.setText(html.toString(), true);

        mailSender.send(message);
    }
}