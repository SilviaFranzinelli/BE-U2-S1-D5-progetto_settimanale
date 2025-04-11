package it.epicode.progetto.settimanale.repository;

import it.epicode.progetto.settimanale.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {}
