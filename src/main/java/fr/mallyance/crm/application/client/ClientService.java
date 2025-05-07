package fr.mallyance.crm.application.client;

import fr.mallyance.crm.domain.client.ClientServicePort;
import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.infrastructure.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService implements ClientServicePort {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClient(int id) {
        return clientRepository.findClient(id);
    }

    @Override
    public Client getClient(String raisonSociale) {
        return clientRepository.findClientByReference(raisonSociale);
    }

    @Override
    public List<Client> getClients() {
        return clientRepository.findAllClients();
    }

    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.addClient(client);
    }

    @Override
    public Client modifierClient(Client client) {
        return null;
    }
}
