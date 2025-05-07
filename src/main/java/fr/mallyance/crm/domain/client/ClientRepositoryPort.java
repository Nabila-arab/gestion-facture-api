package fr.mallyance.crm.domain.client;

import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.domain.entities.Facture;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepositoryPort {

    public Client findClient(int id);
    public Client findClientByReference(String raisonSociale);
    public Client addClient(Client client);
    public List<Client> findAllClients();
    //public List<Client> findByDateEcheance(LocalDate date);
    public Client updateClient(Client facture);
}
