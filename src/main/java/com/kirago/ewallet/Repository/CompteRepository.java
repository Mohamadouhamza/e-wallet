package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Compte;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {

    Optional<Compte> findById(String id);

    Compte save(Compte compte);

    void deleteById(String id);
   
}