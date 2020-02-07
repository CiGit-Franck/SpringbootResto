/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.service;

import fty.api.resto.model.Client;
import fty.api.resto.repository.ClientRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author utilisateur
 */
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client clientToCreate) {
        return clientRepository.save(clientToCreate);
    }
    
}
