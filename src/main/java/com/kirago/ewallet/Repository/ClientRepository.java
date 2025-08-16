package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findById(String id);

    Client save(Client client);

    void deleteById(String id);

}
