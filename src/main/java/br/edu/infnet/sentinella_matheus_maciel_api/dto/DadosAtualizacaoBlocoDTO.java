package br.edu.infnet.sentinella_matheus_maciel_api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoBlocoDTO(
        @NotNull
        Long id,
        String nome
) {
}
