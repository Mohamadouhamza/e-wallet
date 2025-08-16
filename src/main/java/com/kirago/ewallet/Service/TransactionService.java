package com.kirago.ewallet.Service;

import com.kirago.ewallet.Model.Transaction;
import com.kirago.ewallet.Model.Compte;
import com.kirago.ewallet.Repository.TransactionRepository;
import com.kirago.ewallet.Repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/*
 * Service de gestion des transactions.
 * Permet de créer et consulter l'historique des transferts et paiements.
 */
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CompteRepository compteRepository;

    public TransactionService(TransactionRepository transactionRepository, CompteRepository compteRepository) {
        this.transactionRepository = transactionRepository;
        this.compteRepository = compteRepository;
    }

    // Lister toutes les transactions
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    // Récupérer une transaction par ID
    public Optional<Transaction> getById(String id) {
        return transactionRepository.findById(id);
    }

    // Supprimer une transaction
    @Transactional
    public void delete(String id) {
        transactionRepository.deleteById(id);
    }

    /**
     * Créer une transaction simple entre deux comptes
     */
    @Transactional
    public Transaction transferer(String idSource, String idDestination, Long montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif");
        }

        Compte source = compteRepository.findById(idSource)
                .orElseThrow(() -> new RuntimeException("Compte source introuvable"));
        Compte destination = compteRepository.findById(idDestination)
                .orElseThrow(() -> new RuntimeException("Compte destination introuvable"));

        if (source.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }

        // Débit et crédit
        source.setSolde(source.getSolde() - montant);
        destination.setSolde(destination.getSolde() + montant);

        compteRepository.save(source);
        compteRepository.save(destination);

        // Enregistrer la transaction
        Transaction transaction = new Transaction();
        transaction.setMontant(montant);
        transaction.setDateTransaction(LocalDateTime.now());
        transaction.setCompteSource(source);
        transaction.setCompteCible(destination);

        return transactionRepository.save(transaction);
    }
}