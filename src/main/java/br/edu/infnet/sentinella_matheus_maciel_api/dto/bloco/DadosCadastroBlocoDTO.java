package br.edu.infnet.sentinella_matheus_maciel_api.dto.bloco;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroBlocoDTO(
        @NotBlank(message = "O nome do bloco é obrigatório")
        String nome
) {
}
