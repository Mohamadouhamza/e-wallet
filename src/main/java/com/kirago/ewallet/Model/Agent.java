package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @Column(name = "id_agent")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "point_conversion")
    private Long pointConversion;

    private String statut;
    
}