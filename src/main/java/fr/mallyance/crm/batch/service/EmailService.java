package fr.mallyance.crm.batch.service;

import fr.mallyance.crm.domain.entities.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendFacturesEmail(List<Facture> factures, String[] recipientEmail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Configuration de l'email
        helper.setTo(recipientEmail);
        helper.setSubject("Factures Traitées");
        helper.setFrom("gpt@mallyance.fr");

        // Génération du contenu HTML
        Context context = new Context();
        context.setVariable("factures", factures);
        String htmlContent = templateEngine.process("email-template", context);

        // Ajout du contenu à l'email
        helper.setText(htmlContent, true);

        // Envoi de l'email
        mailSender.send(message);
    }
}
