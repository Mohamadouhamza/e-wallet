package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Banque;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanqueRepository extends JpaRepository<Banque, String> {

    Optional<Banque> findById(String id);

    Banque save(Banque banque);

    void deleteById(String id);

}