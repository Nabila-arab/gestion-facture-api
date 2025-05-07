package fr.mallyance.crm.batch;

import fr.mallyance.crm.batch.service.EmailService;
import fr.mallyance.crm.domain.entities.Facture;
import jakarta.mail.MessagingException;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RelanceFactureWriter implements ItemWriter<Facture> {

    @Autowired
    private EmailService emailService;

    @Override
    public void write(Chunk<? extends Facture> chunk) throws Exception {

        List<Facture> factures = new ArrayList<>();
        chunk.forEach(f -> {
            factures.add(f);
            System.out.println("Facture écrite : " + f.getReference());
        });

        String[] emails = {"ys.shopping.ys@gmail.com"};//, "support@terra-interim.com"};

        try {
            emailService.sendFacturesEmail(factures, emails);
            System.out.println("===============> Mail was sent");
        } catch (MessagingException e) {
            System.out.println("===============> Mail Sending Error !");
            e.printStackTrace();
        }

    }
}
