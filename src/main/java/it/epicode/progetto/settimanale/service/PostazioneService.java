package it.epicode.progetto.settimanale.service;

import it.epicode.progetto.settimanale.model.*;
import it.epicode.progetto.settimanale.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostazioneService {

    private final PostazioneRepository postazioneRepo;

    public List<Postazione> cercaPerTipoECitta(TipoPostazione tipo, String citta) {
        return postazioneRepo.findByTipoAndEdificio_Citta(tipo, citta);
    }
}
