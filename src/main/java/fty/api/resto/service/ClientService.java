/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.service;

import fty.api.resto.model.Client;
import org.springframework.stereotype.Service;

/**
 *
 * @author utilisateur
 */
@Service
public interface ClientService {
    
    Client createClient(Client clientToCreate);
}
