package br.edu.infnet.sentinella_matheus_maciel_api.dto.unidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUnidadeDTO(
        @NotBlank
        String numero,

        String descricao,

        @NotNull
        Long blocoId
) {
}
