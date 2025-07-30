package br.edu.infnet.sentinella_matheus_maciel_api.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Bloco")
@Table(name = "blocos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


}
