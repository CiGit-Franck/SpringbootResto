/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fty.api.resto.model;

import javax.persistence.*;

/**
 *
 * @author utilisateur
 */
@Entity
public class Client {
    
    @Id
    @SequenceGenerator(name="client_seq_id", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_seq_id")
    private Long id;
}
