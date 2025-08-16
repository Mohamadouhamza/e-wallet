package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Commercant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercantRepository extends JpaRepository<Commercant, String> {

    Optional<Commercant> findById(String id);

    Commercant save(Commercant commercant);

    void deleteById(String id);

}
