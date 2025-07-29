package br.edu.infnet.sentinella_matheus_maciel_api.dto;

import br.edu.infnet.sentinella_matheus_maciel_api.model.domain.Bloco;

public record DadosListagemBlocoDTO(
    Long id,
    String nome
) {
    public DadosListagemBlocoDTO(Bloco bloco) {
        this(bloco.getId(), bloco.getNome());
    }
}
