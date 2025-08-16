package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Agent;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, String> {

    Optional<Agent> findById(String id);

    Agent save(Agent agent);

    void deleteById(String id);
    
}

