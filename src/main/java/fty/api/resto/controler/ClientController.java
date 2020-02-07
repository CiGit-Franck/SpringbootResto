/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.controler;

import fty.api.resto.model.Client;
import fty.api.resto.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author utilisateur
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client clientToCreate) {
        Client savedClient = clientService.createClient(clientToCreate);
        return ResponseEntity.ok(savedClient);
    }
    
}
