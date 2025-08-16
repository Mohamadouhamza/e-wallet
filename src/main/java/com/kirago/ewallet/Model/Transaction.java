package com.kirago.ewallet.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "id_transaction")
    private String id;

    private Long montant;

    @Column(name = "type_transaction")
    private String typeTransaction;

    @Column(name = "date_transaction")
    private LocalDateTime dateTransaction;

    @ManyToOne
    @JoinColumn(name = "id_compte_source", nullable = false)
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "id_compte_cible", nullable = false)
    private Compte compteCible;

    @Lob
    private String qrCodeBase64;

}