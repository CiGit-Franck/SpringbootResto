/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.repository;

import fty.api.resto.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author utilisateur
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
