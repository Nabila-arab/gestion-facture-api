package fr.mallyance.crm.infrastructure.mappers;

import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.infrastructure.entities.ClientEntity;
import fr.mallyance.crm.infrastructure.entities.FactureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client mapToClient(ClientEntity clientEntity);

    ClientEntity mapToClientEntity(Client client);
}
