package it.epicode.progetto.settimanale.repository;

import it.epicode.progetto.settimanale.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUtenteAndData(Utente utente, LocalDate data);
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtente_Username(String username);
}
