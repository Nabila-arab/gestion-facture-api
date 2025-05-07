package fr.mallyance.crm.domain.client;

import fr.mallyance.crm.domain.entities.Client;

import java.util.List;

public interface ClientServicePort {

    public Client getClient(int id);
    public Client getClient(String reference);
    public List<Client> getClients();
    public Client ajouterClient(Client client );
    public Client modifierClient(Client client);
}
