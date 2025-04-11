package it.epicode.progetto.settimanale.service;

import it.epicode.progetto.settimanale.model.*;
import it.epicode.progetto.settimanale.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepo;
    private final UtenteRepository utenteRepo;
    private final PostazioneRepository postazioneRepo;

    public Prenotazione prenota(String username, Long idPostazione, LocalDate data) {
        Utente utente = utenteRepo.findById(username).orElseThrow();
        Postazione postazione = postazioneRepo.findById(idPostazione).orElseThrow();

        if (prenotazioneRepo.existsByUtenteAndData(utente, data)) {
            throw new IllegalStateException("Utente ha già una prenotazione per questa data");
        }

        if (prenotazioneRepo.existsByPostazioneAndData(postazione, data)) {
            throw new IllegalStateException("Postazione già prenotata per questa data");
        }

        Prenotazione prenotazione = new Prenotazione(null, utente, postazione, data);
        return prenotazioneRepo.save(prenotazione);
    }

    public List<Prenotazione> getPrenotazioniUtente(String username) {
        return prenotazioneRepo.findByUtente_Username(username);
    }
}
