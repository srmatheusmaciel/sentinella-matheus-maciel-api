package br.edu.infnet.sentinella_matheus_maciel_api.model.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Unidade")
@Table(name = "unidades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bloco_id", nullable = false)
    private Bloco bloco;

}
