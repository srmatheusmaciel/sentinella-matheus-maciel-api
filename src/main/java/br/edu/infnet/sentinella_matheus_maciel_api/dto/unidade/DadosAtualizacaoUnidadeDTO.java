package br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoUnidadeDTO(
        @NotNull
        Long id,
        String numero,
        String descricao,
        Long blocoId
) {
}
