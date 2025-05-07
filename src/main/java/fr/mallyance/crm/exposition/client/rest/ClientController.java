package fr.mallyance.crm.exposition.client.rest;

import fr.mallyance.crm.application.client.ClientService;
import fr.mallyance.crm.domain.entities.Client;
import fr.mallyance.crm.exposition.client.dto.ClientDto;
import fr.mallyance.crm.exposition.client.mapper.ClientMapper;
import fr.mallyance.crm.exposition.facture.rest.FactureController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*") // Permet de gérer les requêtes depuis Angular
@Tag(name = "Client", description = "API for managing clients") // pour le swagger
public class ClientController {

    Logger logger = Logger.getLogger(FactureController.class.getName());
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    @Operation(operationId = "AddClient", method = "POST", summary = "Ajout d'un nouveau client", description = "Récupère les données de l'objet client passé par la partie front et appelle le service d'ajout d'un nouveau client en BDD")
    public ResponseEntity<ClientDto> addClient(@RequestBody ClientDto clientDto) {

        logger.info("=====> Ajouter un nouveau client ########### DEBUT ##############");
        Client client = clientMapper.mapToClient(clientDto);
        client = clientService.ajouterClient(client);
        logger.info("=====> Ajouter un nouveau client ########### FIN ##############");

        return ResponseEntity.ok(clientMapper.mapToClientDto(client));
    }

    @GetMapping
    @Operation(operationId = "getClients", method = "GET", summary = "Récupérer tous les clients", description = "Récupérer tous les clients disponibles pour les afficher côté font")
    public ResponseEntity<List<ClientDto>> getClients() {

        logger.info("=====> récupération des clients ########### DEBUT ##############");
        List<ClientDto> clientDtos = new ArrayList<>();
        //Client client = clientMapper.mapToClient(clientDto);
        List<Client> clients = clientService.getClients();
        clients.forEach(client -> clientDtos.add(clientMapper.mapToClientDto(client)));
        logger.info("=====> récupération des clients ########### FIN ##############");

        return ResponseEntity.ok(clientDtos);
    }

    @PutMapping("/{raisonSociale}")
    @Operation(operationId = "updateClient", method = "PUT", summary = "Mettre à jour un client", description = "Mettre à jour les données du client en BDD avec les nouvelles données du front")
    public ResponseEntity<ClientDto> updateClient(@PathVariable String raisonSociale, @RequestBody ClientDto clientDto){

        Client client =  clientService.modifierClient(clientMapper.mapToClient(clientDto));
        return ResponseEntity.ok(clientMapper.mapToClientDto(client));
    }
}
