package br.com.fiap.droneagro.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(String mailTo, String subject, String body) 
    {
        var mensagem = new SimpleMailMessage();

        mensagem.setTo(mailTo);
        mensagem.setSubject(subject);
        mensagem.setText(body);

        mailSender.send(mensagem);
    }
    
}
