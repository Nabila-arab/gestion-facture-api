package fr.mallyance.crm.exposition.client.mapper;

import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.exposition.client.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client mapToClient(ClientDto dto){

        Client client = new Client();
        client.setRaisonSociale(dto.getRaisonSociale());
        client.setEmail(dto.getEmail());
        client.setAdresse(dto.getAdresse());
        client.setTelephone(dto.getTelephone());

        return client;
    }


    public ClientDto mapToClientDto(Client client){

        ClientDto dto = new ClientDto();

        dto.setId(client.getIdClient());
        dto.setRaisonSociale(client.getRaisonSociale());
        dto.setEmail(client.getEmail());
        dto.setAdresse(client.getAdresse());
        dto.setTelephone(client.getTelephone());

        return dto;
    }
}
