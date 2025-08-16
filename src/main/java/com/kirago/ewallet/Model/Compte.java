package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "compte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @Column(name = "id_compte")
    private String id;

    private Long solde;

    @Column(name = "type_compte")
    private String typeCompte;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;
}