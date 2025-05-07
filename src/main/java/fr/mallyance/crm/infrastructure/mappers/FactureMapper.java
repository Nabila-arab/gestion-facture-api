package fr.mallyance.crm.infrastructure.mappers;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.infrastructure.entities.FactureEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactureMapper {

    Facture mapToFacture(FactureEntity entity);

    FactureEntity mapToFactureEntity(Facture facture);

}
