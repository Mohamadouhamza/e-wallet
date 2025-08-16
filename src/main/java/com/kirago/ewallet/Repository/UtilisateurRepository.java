package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Optional<Utilisateur> findById(String id);

    Utilisateur save(Utilisateur utilisateur);

    void deleteById(String id);

}