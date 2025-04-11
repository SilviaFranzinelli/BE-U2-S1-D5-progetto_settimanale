package it.epicode.progetto.settimanale.controller;

import it.epicode.progetto.settimanale.model.Prenotazione;
import it.epicode.progetto.settimanale.service.PrenotazioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
@RequiredArgsConstructor
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @PostMapping
    public Prenotazione prenota(
            @RequestParam String username,
            @RequestParam Long idPostazione,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data
    ) {
        return prenotazioneService.prenota(username, idPostazione, data);
    }

    @GetMapping("/{username}")
    public List<Prenotazione> getPrenotazioniUtente(@PathVariable String username) {
        return prenotazioneService.getPrenotazioniUtente(username);
    }
}
