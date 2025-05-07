package fr.mallyance.crm.infrastructure.repository;

import fr.mallyance.crm.domain.client.ClientRepositoryPort;
import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.infrastructure.entities.ClientEntity;
import fr.mallyance.crm.infrastructure.jpa.ClientRepositoryJpa;
import fr.mallyance.crm.infrastructure.mappers.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository implements ClientRepositoryPort {

    private final ClientRepositoryJpa clientRepositoryJpa;
    private final ClientMapper clientMapper;

    public ClientRepository(ClientRepositoryJpa clientRepositoryJpa, ClientMapper clientMapper) {
        this.clientRepositoryJpa = clientRepositoryJpa;
        this.clientMapper = clientMapper;
    }


    @Override
    public Client findClient(int id) {
        return null;
    }

    @Override
    public Client findClientByReference(String raisonSociale) {
        return null;
    }

    @Override
    public Client addClient(Client client) {
        ClientEntity clientEntity = clientMapper.mapToClientEntity(client);
        return clientMapper.mapToClient( clientRepositoryJpa.save(clientEntity));
    }

    @Override
    public List<Client> findAllClients() {
        List<Client> clients = new ArrayList<>();
        List<ClientEntity> clientEntities = clientRepositoryJpa.findAll();

        clientEntities.forEach( entity -> clients.add(clientMapper.mapToClient(entity)));

        return clients;
    }

    @Override
    public Client updateClient(Client client) {
        return clientMapper.mapToClient(clientRepositoryJpa.save(clientMapper.mapToClientEntity(client)));
    }
}
