package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Client;
import com.kirago.ewallet.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service pour la gestion des Clients.
 * Contient les opérations CRUD + méthodes métiers si nécessaire.
 */
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Récupérer tous les clients
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    // Récupérer un client par ID
    public Optional<Client> getById(String id) {
        return clientRepository.findById(id);
    }

    // Créer ou mettre à jour un client
    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // Supprimer un client
    @Transactional
    public void delete(String id) {
        clientRepository.deleteById(id);
    }
}