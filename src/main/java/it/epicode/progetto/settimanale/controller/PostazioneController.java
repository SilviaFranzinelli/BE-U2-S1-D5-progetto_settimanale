package it.epicode.progetto.settimanale.controller;

import it.epicode.progetto.settimanale.model.*;
import it.epicode.progetto.settimanale.service.PostazioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postazioni")
@RequiredArgsConstructor
public class PostazioneController {

    private final PostazioneService postazioneService;

    @GetMapping("/ricerca")
    public List<Postazione> cerca(
            @RequestParam TipoPostazione tipo,
            @RequestParam String citta
    ) {
        return postazioneService.cercaPerTipoECitta(tipo, citta);
    }
}
