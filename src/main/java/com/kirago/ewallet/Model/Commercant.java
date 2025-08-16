package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "commercant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commercant {

    @Id
    @Column(name = "id_commercant")
    private String id;

    @OneToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @Column(name = "nom_commerce")
    private String nomCommerce;

    private String categorie;
}
