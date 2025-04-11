package it.epicode.progetto.settimanale.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    @Id
    private String username;

    private String nomeCompleto;
    private String email;
}
