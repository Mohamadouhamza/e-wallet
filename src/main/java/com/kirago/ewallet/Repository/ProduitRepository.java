package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Produit;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, String> {

    Optional<Produit> findById(String id);

    Produit save(Produit produit);

    void deleteById(String id);

    List<Produit> findAll();
    
}

